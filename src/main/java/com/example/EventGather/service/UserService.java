package com.example.EventGather.service;

import com.example.EventGather.model.entity.User;
import java.util.List;

public interface UserService {
      User createUser (User user);
      User getUserById(String id);
      void delete(String id);
      List<User> getAllUsers();
      User updateUser(String id,String name,String email,String password);
}
