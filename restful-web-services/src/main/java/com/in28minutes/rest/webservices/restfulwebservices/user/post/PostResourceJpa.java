package com.in28minutes.rest.webservices.restfulwebservices.user.post;

import com.in28minutes.rest.webservices.restfulwebservices.user.User;
import com.in28minutes.rest.webservices.restfulwebservices.user.UserNotFoundException;
import com.in28minutes.rest.webservices.restfulwebservices.user.jpa.UserJpaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/jpa/users/")
public class PostResourceJpa {
    private PostJpaService postService;

    private UserJpaService userService;

    public PostResourceJpa(PostJpaService postService, UserJpaService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/posts")
    public List<Post> retrieveAllPosts(){
        return postService.findAll();
    }

    @GetMapping("/{id}/posts")
    public List<Post> retrieveAllPostsForUser(@PathVariable Integer id){
        User u = userService.findOne(id);
        if(u == null) throw new UserNotFoundException("User with id: " + id + " not found!");
        return u.getPosts();
    }

//    @GetMapping("/{id}/posts/{post}")
//    public ResponseEntity<EntityModel<Post>> retrieveUser(@PathVariable Integer id){
//        Post post = service.findOne(id);
//        if(post==null) throw new UserNotFoundException("id: " + id);
//
//        EntityModel<Post> model = EntityModel.of(post);
//
//        WebMvcLinkBuilder allUsers = linkTo(methodOn(this.getClass()).retrieveAllUsers());
//        model.add(allUsers.withRel("all-users"));
//        WebMvcLinkBuilder prev;
//        if(post.getId()!=1){
//            prev = linkTo(methodOn(this.getClass()).retrieveUser(post.getId()-1));
//            model.add(prev.withRel("previous-user"));
//        }
//        WebMvcLinkBuilder next;
//        if(post.getId()!= UserDaoService.getCount()) {
//            next = linkTo(methodOn(this.getClass()).retrieveUser(post.getId() + 1));
//            model.add(next.withRel("next-user:"));
//        }
//
//
//        return new ResponseEntity<>(model, HttpStatus.OK);
//    }

    @PostMapping("/{id}/posts")
    public ResponseEntity createPost( @PathVariable int id, @Valid @RequestBody Post post){
        User u = userService.findOne(id);

        if(u == null) throw new UserNotFoundException("User with id: " + id + " not found!");
        post.setUser(u);

        Post savedPost = postService.savePost(post);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

//    @DeleteMapping("{id}")
//    public void deleteUser(@PathVariable int id){
//        postJpaService.deleteById(id);
//    }
}
