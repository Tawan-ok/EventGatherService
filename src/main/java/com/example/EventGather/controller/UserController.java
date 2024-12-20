package com.example.EventGather.controller;

import com.example.EventGather.model.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
public interface UserController {

    @Operation(summary = "Find all users")
    @GetMapping("/get-all-users")
    ResponseEntity <List<User>> getAllUsers();

    @Operation(summary = "Find a user")
    @GetMapping("/get-user")
    ResponseEntity<User> getUserById(@RequestParam @Valid String id);

    @Operation(summary = "Create a user")
    @PostMapping("/create")
    ResponseEntity<User> registerUser(@RequestBody @Valid User user);

    @Operation(summary = "Update a user")
    @PutMapping("/update/{id}")
    ResponseEntity<User> updateUser( @RequestParam @Valid String id,@RequestBody User user);

    @Operation(summary = "Delete a user")
    @DeleteMapping("/delete")
    ResponseEntity<Void> deleteUser(@RequestParam String id);
}
