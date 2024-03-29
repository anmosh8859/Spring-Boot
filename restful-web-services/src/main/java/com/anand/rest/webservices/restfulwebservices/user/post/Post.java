package com.anand.rest.webservices.restfulwebservices.user.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.anand.rest.webservices.restfulwebservices.user.User;
import jakarta.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue
    @JsonProperty("Post Id")
    private Integer id;

    @JsonProperty("Description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Post() {
    }

    public Post(Integer id, String description, User user) {
        this.id = id;
        this.description = description;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", desc='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
