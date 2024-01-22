package com.in28minutes.rest.webservices.restfulwebservices.user.post;

import com.in28minutes.rest.webservices.restfulwebservices.user.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostJpaService {

    PostRepository repository;

    public PostJpaService(PostRepository repository) {
        this.repository = repository;
    }

//    private static List<Post> users = new ArrayList<>();
//
//    static{
//        users.add(new User(++count,"Adam", LocalDate.now().minusYears(30)));
//        users.add(new User(++count,"Eve", LocalDate.now().minusYears(25)));
//        users.add(new User(++count,"Jim", LocalDate.now().minusYears(20)));
//    }

    public List<Post> findAll(){
        return repository.findAll();
    }

    public Post findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    public Post savePost(Post post){
        return repository.save(post);
    }

    public void deleteById(int id){
        if(repository.findById(id).orElse(null)==null) return;
        repository.deleteById(id);
    }

    public Long getCount() {
        return repository.count();
    }
}
