package com.in28minutes.rest.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.ZoneOffset;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class UserResource {
    private UserDaoService service;

    public UserResource(UserDaoService service){
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
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
        if(user.getId()!=UserDaoService.getCount()) {
            next = linkTo(methodOn(this.getClass()).retrieveUser(user.getId() + 1));
            model.add(next.withRel("next-user:"));
        }

        MappingJacksonValue jacksonValue = new MappingJacksonValue(user);
        ResponseEntity<EntityModel<User>> entity = new ResponseEntity<>(model, HttpStatus.OK);

        return entity;
    }

    @PostMapping("/users")
    public ResponseEntity createUser(@Valid @RequestBody User user){
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        service.deleteById(id);
    }
}
