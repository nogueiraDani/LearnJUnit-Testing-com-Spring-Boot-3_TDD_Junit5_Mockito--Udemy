package com.dani.lessons.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dani.lessons.entity.Person;
import com.dani.lessons.exceptions.ResourceNotFoundException;
import com.dani.lessons.repositories.PersonRepository;
import com.dani.lessons.service.PersonService;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    private Person personTest;
    private String firstName = "dani";
    private String lastName = "ramp";

    @BeforeEach
    void setUp() {

        personRepository.deleteAll();

        // Given | Arrange
        personTest = new Person(
                firstName,
                lastName,
                "SC");

    }

    @DisplayName("Given Person Object When Save Person then Return Person Object")
    @Test
    void testGivenPersonObject_When_SavePerson_thenReturn_PersonObject() {

        personRepository.save(personTest);

        // Given | Arrange
        given(personRepository.findByFirstNameAndLastNameJPQL(
                anyString(),
                anyString()))
                .willReturn(Optional.empty());

        given(personRepository.save(personTest))
                .willReturn(personTest);

        // When | Act
        Person savedPerson = personService.createPerson(personTest);

        // Then | Assert
        assertNotNull(savedPerson);
        assertEquals(savedPerson.getFirstName(), personTest.getFirstName());
    }

    @DisplayName("Given Existing FirstName and LastName When Save Person then Throws Exception")
    @Test
    void testGivenExistingFirstNameAndLastName_When_SavePerson_thenThrowsException() {

        // Given | Arrange
        given(personRepository.findByFirstNameAndLastNameJPQL(
                anyString(),
                anyString()))
                .willReturn(Optional.of(personTest));

        // When | Act
        assertThrows(ResourceNotFoundException.class, () -> {
            personService.createPerson(personTest);
        });

        // Then | Assert
        verify(personRepository, never())
                .save(any(Person.class));
    }

    @DisplayName("Given PersonList When FindAll Persons then Return PersonList")
    @Test
    void testGivenPersonList_When_FindAll_thenReturnPersonList() {

        Person personTest2 = new Person(
                "dani2",
                "ramp2",
                "SC");

        // Given | Arrange
        given(personRepository.findAll())
                .willReturn(java.util.List.of(personTest, personTest2));

        // When | Act
        List<Person> personList = personService.findAll();

        // Then | Assert
        assertNotNull(personList);
        assertEquals(2, personList.size());
    }

    @DisplayName("Given Empty PersonList When FindAll Persons then Return Empty PersonList")
    @Test
    void testGivenEmptyPersonList_When_FindAll_thenReturnEmptyPersonList() {

        // Given | Arrange
        given(personRepository.findAll())
                .willReturn(Collections.emptyList());

        // When | Act
        List<Person> personList = personService.findAll();

        // Then | Assert
        assertTrue(personList.isEmpty());
        assertEquals(0, personList.size());

    }

    @DisplayName("Given Person Id When FindById then Return Person Object")
    @Test
    void testGivenPersonId_When_FindById_thenReturn_PersonObject() {

        personRepository.save(personTest);

        // Given | Arrange
        given(personRepository.findById(anyLong())).willReturn(Optional.of(personTest));

        // When | Act
        Person savedPerson = personService.findById(1L);

        // Then | Assert
        assertNotNull(savedPerson);
        assertEquals("dani", personTest.getFirstName());
    }

    @DisplayName("Given Person Id When FindById then Return Person Object")
    @Test
    void testGivenPersonId_When_UpdatePerson_thenReturn_UpdatedPersonObject() {

        // Given | Arrange
        personTest.setId(1L);
        given(personRepository.findById(anyLong())).willReturn(Optional.of(personTest));

        personTest.setFirstName(firstName + " updated");

        given(personRepository.save(personTest)).willReturn(personTest);

        // When | Act
        Person updatedPerson = personService.updatePerson(personTest);

        // Then | Assert
        assertNotNull(updatedPerson);
        assertEquals("dani updated", personTest.getFirstName());
    }

    @DisplayName("Given Person Id When DeletePerson then do nothing")
    @Test
    void testGivenPersonId_When_DeletePerson_thenReturn_doNothing() {

        // Given | Arrange
        personTest.setId(1L);
        given(personRepository.findById(anyLong())).willReturn(Optional.of(personTest));

        willDoNothing().given(personRepository).delete(personTest);
        
        // When | Act
        personService.deletePerson(personTest.getId());

        // Then | Assert
        verify(personRepository, times(1)).delete(personTest);
    }
}
