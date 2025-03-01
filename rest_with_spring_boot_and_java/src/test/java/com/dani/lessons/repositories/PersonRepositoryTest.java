package com.dani.lessons.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.dani.lessons.entity.Person;

@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

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

        personRepository.save(personTest);
    }

    @DisplayName("Given Person Object When Save Then Return Saved Person")
    @Test
    void testGivenPersonObject_When_Save_ThenReturn_SavedPerson() {

        // When | Act
        Person savedPerson = personRepository.save(personTest);

        // Then | Assert
        assertNotNull(savedPerson);
        assertTrue(savedPerson.getId() > 0);
    }

    @DisplayName("Given List Person When Find All Then Return Person List")
    @Test
    void testGivenListPerson_When_FindAll_ThenReturn_Person_List() {
        // Given | Arrange
        
        Person personTest2 = new Person(
                "leo",
                "nog",
                "SC");

        Person personTest3 = new Person(
                "mari",
                "nog",
                "SC");

        Person personTest4 = new Person(
                "mail",
                "pop",
                "SC");

        personRepository.save(personTest2);
        personRepository.save(personTest3);
        personRepository.save(personTest4);

        // When | Act
        List<Person> personList = personRepository.findAll();

        // Then | Assert
        assertNotNull(personList);
        //retorna 4 pois o método save foi chamado no before each
        assertEquals(4, personList.size());
    }

    @DisplayName("Given Person Object When Find By ID Then Return Person Object")
    @Test
    void testGivenPersonObject_When_FindById_ThenReturn_PersonObject() {


        // When | Act
        Person savedPerson = personRepository.findById(personTest.getId()).get();

        // Then | Assert
        assertNotNull(savedPerson);
        assertEquals(personTest.getId(), savedPerson.getId());
    }

    @DisplayName("Given Person Object When Find By Name Then Return Person Object")
    @Test
    void testGivenPersonObject_When_FindByName_ThenReturn_PersonObject() {

        // When | Act
        Person savedPerson = personRepository.findByFirstName(personTest.getFirstName()).get();

        // Then | Assert
        assertNotNull(savedPerson);
        assertEquals(personTest.getId(), savedPerson.getId());
    }

    @DisplayName("Given Person Object When Update Person Then Return Updated Person Object")
    @Test
    void testGivenPersonObject_When_Update_ThenReturn_UpdatedPersonObject() {

        // When | Act
        Person savedPerson = personRepository.findByFirstName(personTest.getFirstName()).get();
        savedPerson.setFirstName("daniela");
        savedPerson.setLastName("rampim");

        Person updatedPerson = personRepository.save(savedPerson);

        // Then | Assert
        assertNotNull(updatedPerson);
        assertEquals(personTest.getFirstName(), updatedPerson.getFirstName());
    }

    @DisplayName("Given Person Object When Delete Person Then Remove Person Object")
    @Test
    void testGivenPersonObject_When_Delete_Then_RemovePersonObject() {

        // When | Act
        personRepository.delete(personTest);
        Optional<Person> deletedPerson = personRepository.findById(personTest.getId());

        // Then | Assert
        assertTrue(deletedPerson.isEmpty());
    }

    @DisplayName("Given Person Object When Find By FirstName and LastName with JPQL Then Return Person Object")
    @Test
    void testGivenPersonObject_When_FindByFirstNameAndLastNameJPQL_ThenReturn_PersonObject() {

        // When | Act
        Person savedPerson = personRepository.findByFirstNameAndLastNameJPQL(firstName, lastName).get();

        // Then | Assert
        assertNotNull(savedPerson);
        assertEquals(firstName, savedPerson.getFirstName());
        assertEquals(lastName, savedPerson.getLastName());
    }

    @DisplayName("Given Person Object When Find By FirstName and LastName with Named Parameters Then Return Person Object")
    @Test
    void testGivenPersonObject_When_FindByFirstNameAndLastNameNamedParameters_ThenReturn_PersonObject() {

        // When | Act
        Person savedPerson = personRepository.findByFirstNameAndLastNameNamedParameters(firstName, lastName).get();

        // Then | Assert
        assertNotNull(savedPerson);
        assertEquals(firstName, savedPerson.getFirstName());
        assertEquals(lastName, savedPerson.getLastName());
    }

    @DisplayName("Given Person Object When Find By FirstName and LastName with Native SQL Then Return Person Object")
    @Test
    void testGivenPersonObject_When_FindByFirstNameAndLastNameNativeSQL_ThenReturn_PersonObject() {

        // When | Act
        Person savedPerson = personRepository.findByFirstNameAndLastNameNativeQuery(firstName, lastName).get();

        // Then | Assert
        assertNotNull(savedPerson);
        assertEquals(firstName, savedPerson.getFirstName());
        assertEquals(lastName, savedPerson.getLastName());
    }

    @DisplayName("Given Person Object When Find By FirstName and LastName with Native SQL And Named Parameters Then Return Person Object")
    @Test
    void testGivenPersonObject_When_FindByFirstNameAndLastNameNativeSQLAndNamedParameters_ThenReturn_PersonObject() {

        // When | Act
        Person savedPerson = personRepository.findByFirstNameAndLastNameNativeQueryNamedParameters(firstName, lastName)
                .get();

        // Then | Assert
        assertNotNull(savedPerson);
        assertEquals(firstName, savedPerson.getFirstName());
        assertEquals(lastName, savedPerson.getLastName());
    }

}
