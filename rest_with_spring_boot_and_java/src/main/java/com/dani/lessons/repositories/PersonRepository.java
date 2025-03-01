package com.dani.lessons.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dani.lessons.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByFirstName(String firstName);

    // Custom query with JPQL
    @Query("SELECT p FROM Person p WHERE p.firstName = ?1 AND p.lastName = ?2")
    Optional<Person> findByFirstNameAndLastNameJPQL(String firstName, String lastName);

    // Custom query named parameters
    @Query("SELECT p FROM Person p WHERE p.firstName = :firstName AND p.lastName = :lastName")
    Optional<Person> findByFirstNameAndLastNameNamedParameters(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName);

    // Custom query native SQL
    @Query(value = "SELECT * FROM person WHERE first_name = ?1 AND last_name = ?2", nativeQuery = true)
    Optional<Person> findByFirstNameAndLastNameNativeQuery(String firstName, String lastName);

    // Custom query native SQL and named parameters
    @Query(value = "SELECT * FROM person WHERE first_name = :firstName AND last_name = :lastName", nativeQuery = true)
    Optional<Person> findByFirstNameAndLastNameNativeQueryNamedParameters(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName);

}
