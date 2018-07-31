package com.sidneyspe.web;

import com.sidneyspe.domain.User;
import com.sidneyspe.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private UserRepository userRepository;

    @Inject
    public void setService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(
            method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.GET)
    public ResponseEntity<Collection<User>> getAllUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<User> getUserWithId(@PathVariable Long id) {
        return new ResponseEntity<>(userRepository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(
            params = {"name"},
            method = RequestMethod.GET)
    public ResponseEntity<Collection<User>> findUserWithName(@RequestParam(value = "name") String name) {
        return new ResponseEntity<>(userRepository.findByName(name), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<User> updateUserFromDB(@PathVariable("id") long id, @RequestBody User user) {

        User currentUser = userRepository.findOne(id);
        currentUser.setName(user.getName());

        return new ResponseEntity<>(userRepository.save(currentUser), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public void deleteUserWithId(@PathVariable Long id) {
        userRepository.delete(id);
    }

    @RequestMapping(
            method = RequestMethod.DELETE)
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}
