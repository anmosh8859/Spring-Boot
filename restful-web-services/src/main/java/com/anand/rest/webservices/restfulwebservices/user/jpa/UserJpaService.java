package com.anand.rest.webservices.restfulwebservices.user.jpa;

import com.anand.rest.webservices.restfulwebservices.user.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserJpaService {

    UserRepository repository;

    public UserJpaService(UserRepository repository) {
        this.repository = repository;
    }

//    private static List<User> users = new ArrayList<>();
//
//    static{
//        users.add(new User(++count,"Adam", LocalDate.now().minusYears(30)));
//        users.add(new User(++count,"Eve", LocalDate.now().minusYears(25)));
//        users.add(new User(++count,"Jim", LocalDate.now().minusYears(20)));
//    }

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    public User saveUser(User user){
        return repository.save(user);
    }

    public void deleteById(int id){
        if(repository.findById(id).orElse(null)==null) return;
        repository.deleteById(id);
    }

    public Long getCount() {
        return repository.count();
    }
}
