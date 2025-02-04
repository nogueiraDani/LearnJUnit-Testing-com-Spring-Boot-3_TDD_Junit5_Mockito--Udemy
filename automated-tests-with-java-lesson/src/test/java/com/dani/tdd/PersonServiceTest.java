package com.dani.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.dani.tdd.model.Person;
import com.dani.tdd.service.IPersonService;
import com.dani.tdd.service.PersonService;

public class PersonServiceTest {

    IPersonService personService;
    Person person;

    @BeforeEach
    void setUp() {

        personService = new PersonService();

        person = new Person(
                "Daniel",
                "Silva",
                "daniel@email.com",
                "Male",
                30);

    }

    @DisplayName("When create a Person with success, should return a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {
        // Given | Arrange

        // When | Act
        Person actual = personService.createPerson(person);

        // Then | Assert
        assertNotNull(actual,
                () -> "The person should not be null");

    }

    @DisplayName("When create a Person with success, should contains --FIRSTNAME-- in returned a Person Object")
    @Test
    void tesCreatePerson_WhenSuccess_ShouldContainsFirstNameReturnedPersonObject() {
        // Given | Arrange

        // When | Act
        Person actual = personService.createPerson(person);

        // Then | Assert
        assertEquals(
                person.getFirstName(),
                actual.getFirstName(),
                () -> "The FirstName should be the same");
    }

    @DisplayName("When create a Person with success, should contains --LASTNAME-- in returned a Person Object")
    @Test
    void tesCreatePerson_WhenSuccess_ShouldContainsLastNameReturnedPersonObject() {
        // Given | Arrange

        // When | Act
        Person actual = personService.createPerson(person);

        // Then | Assert
        assertEquals(
                person.getLastName(),
                actual.getLastName(),
                () -> "The LastName should be the same");
    }

    @DisplayName("When create a Person with success, should contains --EMAIL-- in returned a Person Object")
    @Test
    void tesCreatePerson_WhenSuccess_ShouldContainsEmailReturnedPersonObject() {
        // Given | Arrange

        // When | Act
        Person actual = personService.createPerson(person);

        // Then | Assert
        assertEquals(
                person.getEmail(),
                actual.getEmail(),
                () -> "The Email should be the same");
    }

    @DisplayName("When create a Person with success, should contains --GENDER-- in returned a Person Object")
    @Test
    void tesCreatePerson_WhenSuccess_ShouldContainsGenderReturnedPersonObject() {
        // Given | Arrange

        // When | Act
        Person actual = personService.createPerson(person);

        // Then | Assert
        assertEquals(
                person.getGender(),
                actual.getGender(),
                () -> "The Gender should be the same");
    }

    @DisplayName("When create a Person with success, should contains --AGE-- in returned a Person Object")
    @Test
    void tesCreatePerson_WhenSuccess_ShouldContainsAgeReturnedPersonObject() {
        // Given | Arrange

        // When | Act
        Person actual = personService.createPerson(person);

        // Then | Assert
        assertEquals(
                person.getAge(),
                actual.getAge(),
                () -> "The Age should be the same");
    }

    @DisplayName("When create a Person with success, should contains --ID-- in returned a Person Object")
    @Test
    void tesCreatePerson_WhenSuccess_ShouldContainsIDReturnedPersonObject() {
        // Given | Arrange

        // When | Act
        Person actual = personService.createPerson(person);

        // Then | Assert
        assertNotNull(
                actual.getId(),
                () -> "Person ID should not be null");
    }

    @DisplayName("When create a Person with null email should throw IllegalArgumentException")
    @Test
    void testCreatePerson_WithNullEmail_ShouldThrowIllegalArgumentException() {
        // Given | Arrange
        String expectedMessage = "Email is required";

        // When | Act
        Person actual = personService.createPerson(person);
        actual.setEmail(null);

        // Then | Assert

        /*
         * //faz o assert verficiando se há uma exceção
         * 
         * assertThrows(
         * IllegalArgumentException.class,
         * () -> personService.createPerson(actual),
         * () -> "The email should not be null");
         */

        // guarda a exceção em uma variavel
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> personService.createPerson(actual),
                () -> "The email should not be null");

        // faz o assert verificando a mensagem da exceção
        assertEquals(
                expectedMessage,
                exception.getMessage(),
                () -> "The message should be the same");
    }

}
