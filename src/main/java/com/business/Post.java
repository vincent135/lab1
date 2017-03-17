package com.business;

import javax.persistence.*;

/**
 * Created by vincentdemilly on 13/03/2017.
 */
@Entity
@Table(name="POST")
public class Post {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "CONTENT")
    private String content;

    public Post() {
    }

    public Post(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content.toString();
    }
}
