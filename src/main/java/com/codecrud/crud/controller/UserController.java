package com.codecrud.crud.controller;


import com.codecrud.crud.exception.UserNotFoundException;
import com.codecrud.crud.model.User;
import com.codecrud.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

     @Autowired  // injecter l'interface user reposiroty
    private UserRepository userRepository;

     @PostMapping("/adduser")
    User newUser(@RequestBody User newUser){
         
         return userRepository.save(newUser);
     }

     @GetMapping("/user")
     List<User> getAlUsers(){
         return userRepository.findAll();
     }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/updateuser/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/deleteuser/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return  "l'utilisateur "+id+" est supprimé avec succés";
    }
     
}
