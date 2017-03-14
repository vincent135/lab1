package com.config;

import com.repository.JdbcPostRepository;
import com.repository.PostRepositoryInt;
import com.business.PublicationService;
import com.business.PublicationServiceInt;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;


/**
 * Created by vincentdemilly on 13/03/2017.
 */

@Configuration
public class ApplicationConfig {

    @Bean
    public DataSource dataSource () {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("create-schema.sql")
                .build();
    }



    @Bean
    public PostRepositoryInt postRepository(){
        return new JdbcPostRepository(dataSource());
    }

    @Bean
    public PublicationServiceInt publicationService(JdbcPostRepository postRepository){
        return new PublicationService(postRepository);
    }
}

