package com.view;

import com.business.Post;
import com.business.PostRepository;
import com.business.PublicationService;

import java.util.List;

/**
 * Created by vincentdemilly on 13/03/2017.
 */

public class Main
{

    public static void main(String[] args) {

        PostRepository pr = new PostRepository();

        System.out.println("Coucou Polytech");
        PublicationService ps = new PublicationService(pr);

        Post post = new Post("Luminy est cool");
        ps.post(post);

        List<Post> posts = ps.fetchAll();
        System.out.println(posts);
    }
}
