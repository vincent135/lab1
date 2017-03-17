package com.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.Entity;
import javax.sql.DataSource;


/**
 * Created by vincentdemilly on 13/03/2017.
 */

@Configuration
@PropertySource("classpath:applications.properties")
@ComponentScan(basePackages = "com")
@EntityScan("com.business")
public class ApplicationConfig {

    /*@Bean
    public DataSource dataSource () {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("create-schema.sql")
                .build();
    }*/

    /*@Value("${datasource.driverName}")
    private String driverName;

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.username}")
    private String username;

    @Value("${datasource.password}")
    private String password;*/

    @Autowired
    private Environment environment;

    @Bean (name = "dataSource")
    @Profile("PROD")
    public DataSource prodDataSource() {

    /*String driverclassName = environment.getProperty("datasource.driverName");
    String url = environment.getProperty("datasource.url");
    String username = environment.getProperty("datasource.username");
    String password = environment.getProperty("datasource.password");*/


        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUsername(environment.getProperty("datasource.username"));
        basicDataSource.setPassword(environment.getProperty("datasource.password"));
        basicDataSource.setUrl(environment.getProperty("datasource.url"));
        basicDataSource.setDriverClassName(environment.getProperty("datasource.driverName"));

        return basicDataSource;
    }

    @Bean (name = "dataSource")
    @Profile("DEV")
    public DataSource devDataSource() {

        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        return embeddedDatabaseBuilder
                .setType(EmbeddedDatabaseType.H2)
                .addScript("create-schema.sql")
                .addScript("insert-user.sql")
                .build();
    }

  /*  @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
                                                                       JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource);
        emfb.setJpaVendorAdapter(jpaVendorAdapter);
        emfb.setPackagesToScan("com.models");
        return emfb;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.H2);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform("org.hibernate.dialect.HSQLDialect");
        return adapter;
    }*/
}

