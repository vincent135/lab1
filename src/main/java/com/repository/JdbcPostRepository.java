package com.repository;

import com.business.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vincentdemilly on 13/03/2017.
 */

@Component
public class JdbcPostRepository implements PostRepositoryInt {

    private final DataSource dataSource;

    private List<Post> db = new ArrayList<Post>();

    @Autowired
    public JdbcPostRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(Post post) {
        try {

            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO POST (CONTENT) VALUES(?)");
            preparedStatement.setString(1, post.getContent());
            preparedStatement.execute();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Post> findAll() {

        ArrayList<Post> posts = new ArrayList<Post>();

        try {

            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM POST");
            while(rs.next()) {
                String content = rs.getString("CONTENT");
                posts.add(new Post(content));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
    }
}
