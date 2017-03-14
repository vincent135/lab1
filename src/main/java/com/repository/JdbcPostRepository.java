package com.repository;

import com.business.Post;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vincentdemilly on 13/03/2017.
 */
public class JdbcPostRepository implements PostRepositoryInt {

    private final DataSource dataSource;

    private List<Post> db = new ArrayList<Post>();

    public JdbcPostRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(Post post) {
        try {

            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO POST VALUES(?)");
            preparedStatement.setString(1, post.getContent());
            preparedStatement.execute();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Post> findAll() {
        return db;
    }
}
