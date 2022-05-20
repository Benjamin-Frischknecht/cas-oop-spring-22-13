package com.example.demoinitial.config;

import com.example.demoinitial.domain.Person;
import com.example.demoinitial.repository.PersonRepository;
import com.example.demoinitial.utils.HasLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

/**
 * Defines a Bean for the dev-Profile
 */

@Configuration
@Profile("dev")
// @ConditionalOnClass(name = {"org.h2.Driver"})
public class DevConfiguration implements HasLogger {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    @Qualifier("felixMuster")
    Person felixMuster;

    @Autowired
    @Qualifier("maxMustermann")
    Person maxMustermann;

    public DevConfiguration() {
        getLogger().info("Dev Configuration Class");
    }

    @PostConstruct
    public void createPersonData() {
        personRepository.save(felixMuster);
        personRepository.save(maxMustermann);
        getLogger().debug("Person felixMuster and maxMustermann saved to DB");
    }
}
