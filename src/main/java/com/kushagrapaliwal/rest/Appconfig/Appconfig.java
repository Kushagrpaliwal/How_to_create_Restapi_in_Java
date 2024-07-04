package com.kushagrapaliwal.rest.Appconfig;

import com.kushagrapaliwal.rest.Devdb;
import com.kushagrapaliwal.rest.Proddb;
import com.kushagrapaliwal.rest.database;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfig {
    @Bean
    @ConditionalOnProperty(name="project.mode" , havingValue = "development")
    public database getdevBean(){
        return new Devdb();
    }

    @Bean
    @ConditionalOnProperty(name="project.mode" , havingValue = "production")
    public database getprodBean(){
        return new Proddb();
    }

    @Bean
    public ModelMapper getmodelmaper(){
        return  new ModelMapper();
    }

}

