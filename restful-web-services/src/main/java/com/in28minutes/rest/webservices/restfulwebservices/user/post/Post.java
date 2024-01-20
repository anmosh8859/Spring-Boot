package com.in28minutes.rest.webservices.restfulwebservices.user.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.in28minutes.rest.webservices.restfulwebservices.user.User;
import jakarta.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue
    @JsonProperty("Post Id")
    private Integer id;

    @JsonProperty("Description")
    private String desc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Post() {
    }

    public Post(Integer id, String desc, User user) {
        this.id = id;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", user=" + user +
                '}';
    }
}
