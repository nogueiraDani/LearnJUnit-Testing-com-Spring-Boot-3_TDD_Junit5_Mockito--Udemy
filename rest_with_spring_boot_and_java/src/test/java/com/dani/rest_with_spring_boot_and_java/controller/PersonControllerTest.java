package com.dani.rest_with_spring_boot_and_java.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.dani.rest_with_spring_boot_and_java.entity.Person;
import com.dani.rest_with_spring_boot_and_java.exceptions.ResourceNotFoundException;
import com.dani.rest_with_spring_boot_and_java.service.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = PersonController.class)
public class PersonControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private ObjectMapper objectMapper;

        @SuppressWarnings("removal")
        @MockBean // eu sei q esta depreciado, mas não consegui resolver o erro
        private PersonService personService;

        private Person personTest;

        @BeforeEach
        void setUp() {
                // Given / Arrange
                personTest = new Person(
                                "dani",
                                "ramp",
                                "SC");
        }

        @Test
        void testGivenPersonObject_When_CreatePerson_ShouldReturn_SavedPerson()
                        throws JsonProcessingException, Exception {

                // Given | Arrange
                given(personService.createPerson(any(Person.class)))
                                .willAnswer((invocation) -> invocation.getArgument(0));

                // When | Act
                ResultActions response = mockMvc.perform(post("/person").contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(personTest)));

                // Then | Assert
                response.andDo(print()).andExpect(status().isOk())
                                .andExpect(jsonPath("$.firstName", is(personTest.getFirstName())))
                                .andExpect(jsonPath("$.lastName", is(personTest.getLastName())))
                                .andExpect(jsonPath("$.address", is(personTest.getAddress())));
        }

        @Test
        void testGivenListOfPersons_WhenFindAllPersons_thenReturnPersonsList()
                        throws JsonProcessingException, Exception {

                // Given / Arrange
                List<Person> persons = new ArrayList<>();
                persons.add(personTest);
                persons.add(new Person(
                                "mail",
                                "pop",
                                "SC"));

                given(personService.findAll()).willReturn(persons);

                // When / Act
                ResultActions response = mockMvc.perform(get("/person/all"));

                // Then / Assert
                response.andExpect(status().isOk())
                                .andDo(print())
                                .andExpect(jsonPath("$.size()", is(persons.size())));
        }

        @Test
        void testGivenPersonId_WhenFindById_thenReturnPersonObject() throws JsonProcessingException, Exception {

                // Given / Arrange
                long personId = 1L;
                given(personService.findById(personId)).willReturn(personTest);

                // When / Act
                ResultActions response = mockMvc.perform(get("/person/{id}", personId));

                // Then / Assert
                response.andExpect(status().isOk())
                                .andDo(print())
                                .andExpect(jsonPath("$.firstName", is(personTest.getFirstName())))
                                .andExpect(jsonPath("$.lastName", is(personTest.getLastName())));
        }

        @Test
        void testGivenInvalidPersonId_WhenFindById_thenReturnNotFound() throws JsonProcessingException, Exception {

                // Given / Arrange
                long personId = 1L;
                given(personService.findById(personId)).willThrow(ResourceNotFoundException.class);

                // When / Act
                ResultActions response = mockMvc.perform(get("/person/{id}", personId));

                // Then / Assert
                response.andExpect(status().isNotFound())
                                .andDo(print());
        }

        @Test
        void testGivenUpdatedPerson_WhenUpdate_thenReturnUpdatedPersonObject()
                        throws JsonProcessingException, Exception {

                // Given / Arrange
                long personId = 1L;
                given(personService.findById(personId)).willReturn(personTest);
                given(personService.updatePerson(any(Person.class)))
                                .willAnswer((invocation) -> invocation.getArgument(0));

                // When / Act
                Person updatedPerson = new Person(
                                "mail",
                                "pop",
                                "SC");

                ResultActions response = mockMvc.perform(put("/person")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(updatedPerson)));

                // Then / Assert
                response.andExpect(status().isOk())
                                .andDo(print())
                                .andExpect(jsonPath("$.firstName", is(updatedPerson.getFirstName())))
                                .andExpect(jsonPath("$.lastName", is(updatedPerson.getLastName())));
        }

        @Test
        void testGivenUnexistentPerson_WhenUpdate_thenReturnNotFound() throws JsonProcessingException, Exception {

                // Given / Arrange
                long personId = 1L;
                given(personService.findById(personId)).willThrow(ResourceNotFoundException.class);
                given(personService.updatePerson(any(Person.class)))
                                .willAnswer((invocation) -> invocation.getArgument(1));

                // When / Act
                Person updatedPerson = new Person(
                                "mail",
                                "pop",
                                "SC");

                ResultActions response = mockMvc.perform(put("/person")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(updatedPerson)));

                // Then / Assert
                response.andExpect(status().isNotFound())
                                .andDo(print());
        }

        @Test
        void testGivenPersonId_WhenDelete_thenReturnNotContent() throws JsonProcessingException, Exception {

                // Given / Arrange
                long personId = 1L;
                willDoNothing().given(personService).deletePerson(personId);

                // When / Act
                ResultActions response = mockMvc.perform(delete("/person/{id}", personId));

                // Then / Assert
                response.andExpect(status().isNoContent())
                                .andDo(print());
        }
}
