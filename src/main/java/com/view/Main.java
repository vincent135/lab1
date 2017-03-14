package com.view;

import com.business.Post;
import com.config.ApplicationConfig;
import com.repository.PostRepositoryInt;
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

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        PublicationService publicationService= applicationContext.getBean(PublicationService.class);
        Post post = new Post("Luminy est coool");
        publicationService.post(post);

        List<Post> posts = publicationService.fetchAll();
        System.out.println(posts);
    }
}
