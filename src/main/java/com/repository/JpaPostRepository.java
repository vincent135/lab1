package com.repository;

import com.business.Post;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by vincentdemilly on 13/03/2017.
 */

@Repository
@Transactional
public class JpaPostRepository implements PostRepositoryInt {

    @PersistenceContext
    private EntityManager entityManager;

    public JpaPostRepository() {}

    public void save(Post post) {
        entityManager.persist(post);

    }

    public List<Post> findAll() {
        String qlString = "SELECT p FROM Post p";
        Query query = entityManager.createQuery(qlString);
        return query.getResultList();
    }
}
