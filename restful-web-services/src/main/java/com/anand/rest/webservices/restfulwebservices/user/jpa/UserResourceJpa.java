package com.anand.rest.webservices.restfulwebservices.user.jpa;

import com.anand.rest.webservices.restfulwebservices.user.User;
import com.anand.rest.webservices.restfulwebservices.user.UserDaoService;
import com.anand.rest.webservices.restfulwebservices.user.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserResourceJpa {
    private UserJpaService service;

    public UserResourceJpa(UserJpaService service){
        this.service = service;
    }

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public ResponseEntity<EntityModel<User>> retrieveUser(@PathVariable Integer id){
        User user = service.findOne(id);
        if(user==null) throw new UserNotFoundException("id: " + id);

        EntityModel<User> model = EntityModel.of(user);

        WebMvcLinkBuilder allUsers = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        model.add(allUsers.withRel("all-users"));
        WebMvcLinkBuilder prev;
        if(user.getId()!=1){
            prev = linkTo(methodOn(this.getClass()).retrieveUser(user.getId()-1));
            model.add(prev.withRel("previous-user"));
        }
        WebMvcLinkBuilder next;
        if(user.getId()!= UserDaoService.getCount()) {
            next = linkTo(methodOn(this.getClass()).retrieveUser(user.getId() + 1));
            model.add(next.withRel("next-user:"));
        }


        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @PostMapping("/jpa/users")
    public ResponseEntity createUser(@Valid @RequestBody User user){
        User savedUser = service.saveUser(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        service.deleteById(id);
    }
}
