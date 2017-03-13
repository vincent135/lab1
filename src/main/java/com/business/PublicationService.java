package com.business;

import java.util.List;

/**
 * Created by vincentdemilly on 13/03/2017.
 */
public class PublicationService {

    private PostRepository pr;

    public PublicationService(PostRepository prr) {
        this.pr = prr;
    }

    public void post(Post post) {
        pr.save(post);
    }

    public List<Post> fetchAll() {
        return pr.findAll();
    }

}
