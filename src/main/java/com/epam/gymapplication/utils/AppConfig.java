package com.epam.gymapplication.utils;


import com.epam.gymapplication.dao.CommonInMemoryStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.Map;


@Configuration
@ComponentScan(basePackages = {"com.epam.gymapplication"})

public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean
    public CommonInMemoryStorage commonInMemoryStorage(){
        CommonInMemoryStorage storage = new CommonInMemoryStorage();

        // Accessing properties from the environment
        String propertyValue = environment.getProperty("property.key");
        // Use the property value to initialize your storage object

        return storage;
    }
}
