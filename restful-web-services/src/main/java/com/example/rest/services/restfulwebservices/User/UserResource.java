package com.example.rest.services.restfulwebservices.User;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserResource {

    private UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

        //http://localhost:8080/users
        //EntityModel : When we want to use HATEOAS for our API we would wrap the data in EntityModel(If we want to embed links with our API)
        //WebMvcLinkBuilder
        @GetMapping("/users/{userId}")
        public EntityModel<User> retrieveUser(@PathVariable int userId) {
            User user = service.findOne(userId);
            if (user == null) {
                throw new UserNotFoundException("id: " + userId);
            }
            EntityModel<User> entityModel = EntityModel.of(user); // create entityModel to embed links in it
            WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers()); // create a link to reference the API endpoint you want to redirect to
            entityModel.add(link.withRel("all-users")); // add the link back to the model with a relation name
            return entityModel;
        }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Validated @RequestBody User user) {
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteById(id);
    }
}
