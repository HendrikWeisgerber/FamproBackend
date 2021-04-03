package com.example.fampro.modules.user;

import com.example.fampro.modules.user.request.CreateUser;
import com.example.fampro.modules.user.request.UpdateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody @Valid CreateUser user, UriComponentsBuilder uriComponentsBuilder){
        User userAdd = userService.addUser(user);
        UriComponents uriComponents = uriComponentsBuilder.path("User/{id}").buildAndExpand(userAdd.getId());
        URI location = uriComponents.toUri();
        return ResponseEntity.created(location).body(userAdd);

    }

    @PutMapping
    public User updateUser(@RequestBody @Valid UpdateUser update, String email){
        return userService.updateUser(update, email);
    }

    @DeleteMapping
    public void deleteUser(String email){
        userService.deleteUser(email);
    }


}
