package com.example.demoinitial.config;

import com.example.demoinitial.domain.Person;
import com.example.demoinitial.utils.HasLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements CommandLineRunner, HasLogger {

    MyComponent myComponent = null;

    @Autowired
    @Qualifier("felixMuster")
    Person felixMuster;

    Person maxMustermann;

    @Autowired
    public MyBean(MyComponent myComponent, @Qualifier("maxMustermann") Person maxMustermann) {
        this.myComponent = myComponent;
        this.maxMustermann = maxMustermann;
    }

    @Override
    public void run(String[] args) {
        myComponent.hello();
        getLogger().info("Command Line Runner ");
        getLogger().info("Felix Muster Test " + felixMuster.toString());
        getLogger().info("Max Mustermann Test " + maxMustermann.toString());
        getLogger().info(maxMustermann.getFirstName());
        getLogger().info("getTestValue = " + myComponent.getTestValue());
    }
}
