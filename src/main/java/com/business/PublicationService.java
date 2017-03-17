package com.business;

import com.repository.PostRepositoryInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by vincentdemilly on 13/03/2017.
 */
@Component
public class PublicationService implements PublicationServiceInt {

    private PostRepositoryInt pr;

    @Autowired
    public PublicationService(PostRepositoryInt prr) {
        this.pr = prr;
    }

    public void post(Post post) {
        pr.save(post);
    }

    public List<Post> fetchAll() {
        return pr.findAll();
    }
}
