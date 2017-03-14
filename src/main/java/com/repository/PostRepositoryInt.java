package com.repository;

import com.business.Post;

import java.util.List;

/**
 * Created by vincentdemilly on 13/03/2017.
 */
public interface PostRepositoryInt {

    public void save(Post post);
    public List<Post> findAll();
}
