package com.practica.hitfactor.jpa;

import com.practica.hitfactor.jpa.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * JPA Repository for {@link Person} entity
 */
public interface PersonRepository extends CrudRepository<Person, String> {
    List<Person> findByLastNameStartingWithIgnoreCase(@Param("lastName") String lastName);

    Optional<Person> getByEmail(String email);
}
