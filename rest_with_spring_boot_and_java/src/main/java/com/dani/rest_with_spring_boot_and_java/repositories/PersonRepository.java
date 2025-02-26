package com.dani.rest_with_spring_boot_and_java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dani.rest_with_spring_boot_and_java.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}

