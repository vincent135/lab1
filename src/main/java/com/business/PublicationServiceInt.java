package com.business;

import java.util.List;

/**
 * Created by vincentdemilly on 13/03/2017.
 */
public interface PublicationServiceInt {

    public void post(Post post);

    public List<Post> fetchAll();
}
