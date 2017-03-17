package com.web;

import com.business.Post;
import com.config.ApplicationConfig;
import com.business.PublicationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by vincentdemilly on 13/03/2017.
 */

public class Main
{

    public static void main(String[] args) {

        /*System.setProperty("spring.profiles.active", "PROD");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        PublicationService publicationService= applicationContext.getBean(PublicationService.class);
        Post post = new Post("Luminy est coool");
        publicationService.post(post);
        Post post1 = new Post("hey test");
        publicationService.post(post1);

        List<Post> posts = publicationService.fetchAll();
        System.out.println(posts);*/
    }
}
