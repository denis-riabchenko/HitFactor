package com.practica.hitfactor.jpa;

import com.practica.hitfactor.jpa.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.Optional;
import java.util.Random;

/**
 * Application class for Spring Boot
 */
@SpringBootApplication
public class HitFactorApp {
    private static final Logger LOG = LoggerFactory.getLogger(HitFactorApp.class);

    public static void main(String... args) {
        SpringApplication.run(HitFactorApp.class);
    }

    @Bean
    public CommandLineRunner demo(PersonRepository repository) {
        return (args) -> {
            // save a couple of persons
            repository.save(createPerson("Jack", "Bauer"));
            repository.save(createPerson("Chloe", "O'Brian"));
            final String email = repository.save(createPerson("Kim", "Bauer")).getEmail();
            final String id = repository.save(createPerson("David", "Palmer")).getId();
            repository.save(createPerson("Michelle", "Dessler"));

            // fetch all persons
            LOG.info("Persons found with findAll():");
            LOG.info("-------------------------------");
            for (Person person : repository.findAll()) {
                LOG.info(person.toString());
            }
            LOG.info("");

            // fetch an individual person by ID
            Person person = repository.findOne(id);
            LOG.info("Person found with findOne('{}'):", id);
            LOG.info("--------------------------------");
            LOG.info(person.toString());
            LOG.info("");

            // fetch an individual person by email
            Optional<Person> personOptional = repository.getByEmail(email);
            LOG.info("Person found with getByEmail('{}'):", email);
            LOG.info("--------------------------------");
            LOG.info(personOptional.isPresent() ? personOptional.get().toString() : "Not found");
            LOG.info("");

            // fetch persons by last name
            LOG.info("Person found with findByLastNameStartingWithIgnoreCase('bau'):");
            LOG.info("--------------------------------------------");
            for (Person bauer : repository.findByLastNameStartingWithIgnoreCase("bau")) {
                LOG.info(bauer.toString());
            }
            LOG.info("");
        };
    }

    private Person createPerson(String firstName, String lastName) {
        Random random = new Random();
        Calendar birth = Calendar.getInstance();
        birth.add(Calendar.YEAR, 18 + random.nextInt(40));
        birth.add(Calendar.DAY_OF_YEAR, -random.nextInt(365));

        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setBirthDate(birth.getTime());
        person.setEmail(String.format("%s_%s@gmail.com", firstName.toLowerCase(), lastName.toLowerCase()));

        return person;
    }
}
