package com.example.EventGather.controller.implement;

import com.example.EventGather.controller.UserController;
import com.example.EventGather.model.entity.User;
import com.example.EventGather.service.UserService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<User> registerUser(User user) {
        User response = userService.createUser(user);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<User> updateUser(String id,User user) {
        User response = userService.updateUser(id,user.getName(),user.getEmail(),user.getPassword());
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> deleteUser(String id) {
         userService.delete(id);
         return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> response = userService.getAllUsers();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<User> getUserById(String id) {
        User response = userService.getUserById(id);
        return ResponseEntity.ok(response) ;
    }

}
