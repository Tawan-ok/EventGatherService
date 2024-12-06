package com.example.EventGather.service.implement;

import com.example.EventGather.model.entity.User;
import com.example.EventGather.repository.UserRepository;
import com.example.EventGather.service.UserService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl  implements UserService {

    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return  userRepository.save(user);
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(String id) {
         userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
