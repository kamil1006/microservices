package com.example.microservices.controlers;

import com.example.microservices.dao.UserDaoService;
import com.example.microservices.entity.User;
import com.example.microservices.exceptions.UserNotFoundException;
import com.example.microservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
public class UserResource {
//-----------------------------------------
@Autowired
    private UserDaoService service;

@Autowired
    private UserRepository repository;

//-----------------------------------------
@GetMapping("/users1")
    public List<User> retrieveAllUsersStaticService(){
    //return service.findAll();
    List<User> all = service.findAll();
    if(all.isEmpty()) throw new UserNotFoundException("users not found");
    else
    return all;


    /*

     */




}
//-----------------------------------------
@GetMapping("/users")
public List<User> retrieveAllUsersRep(){
    return repository.findAll();

}
//-----------------------------------------
@GetMapping("/users1/{id}")
//public User retrieveUserStatic(@PathVariable int id){
    public  EntityModel<User> retrieveUserStatic(@PathVariable int id){
    User user = service.findOne(id);
    if (user==null)
        throw new UserNotFoundException("id not found"+id);



    //Resource has been replaced by EntityModel
    EntityModel<User> resource = EntityModel.of(user);

    //ControllerLinkBuilder has been replace by WebMvcLinkBuilder
    Link link= WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).retrieveAllUsersStaticService()).withRel("all-users");

    resource.add(link);



    //return user;
    return resource;
}
//-----------------------------------------
@GetMapping("/users/{id}")
public User retrieveUserRep(@PathVariable int id){
    User user = repository.findById(id);
    System.out.println(user);

    if (user==null)
        throw new UserNotFoundException("id not found"+id);


    return user;
}
//-----------------------------------------

@PostMapping("/users1")
public void CreateUser(@Valid @RequestBody User user){
    User savedUser = service.save(user);
}
//-----------------------------------------
@PostMapping("/users")
public ResponseEntity<Object> CreateUserRep(@Valid @RequestBody User user){
    User savedUser = repository.save(user);


    // /user/{id}  savedUser.getId()
    URI location= ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedUser.getId()).toUri();

    return ResponseEntity.created(location).build();
}
//-----------------------------------------
@DeleteMapping("/users1/{id}")
public void deleteUserStatic(@PathVariable int id){
    User user = service.deleteById(id);
    if (user==null)
        throw new UserNotFoundException("id not found"+id);

}
//-----------------------------------------
@DeleteMapping("/users/{id}")
public void deleteUserRep(@PathVariable int id){
    //User user = repository.findById(id);
    repository.deleteById(id);
    System.out.println("deleted id "+ id);


}
//-----------------------------------------
}
