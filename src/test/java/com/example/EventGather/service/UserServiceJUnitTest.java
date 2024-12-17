package com.example.EventGather.service;

import com.example.EventGather.model.entity.User;
import com.example.EventGather.repository.UserRepository;
import com.example.EventGather.service.implement.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceJUnitTest {

    private UserRepository userRepository;
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    void shouldCreateUserSuccessfully() {
        // Given
        User user = User.builder()
            .id("1")
            .name("John Doe")
            .email("john.doe@example.com")
            .password("securepassword")
            .build();

        when(userRepository.save(user)).thenReturn(user);

        // When
        User createdUser = userService.createUser(user);

        // Then
        assertNotNull(createdUser);
        assertEquals("John Doe", createdUser.getName());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void shouldGetUserByIdSuccessfully() {
        // Given
        String userId = "1";
        User user = User.builder()
            .id(userId)
            .name("John Doe")
            .email("john.doe@example.com")
            .password("securepassword")
            .build();

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // When
        User foundUser = userService.getUserById(userId);

        // Then
        assertNotNull(foundUser);
        assertEquals("John Doe", foundUser.getName());
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    void shouldReturnNullWhenUserNotFoundById() {
        // Given
        String userId = "1";
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // When
        User foundUser = userService.getUserById(userId);

        // Then
        assertNull(foundUser);
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    void shouldDeleteUserSuccessfully() {
        // Given
        String userId = "1";

        // When
        userService.delete(userId);

        // Then
        verify(userRepository, times(1)).deleteById(userId);
    }

    @Test
    void shouldGetAllUsersSuccessfully() {
        // Given
        List<User> users = Arrays.asList(
            User.builder().id("1").name("John Doe").email("john.doe@example.com").password("12345").build(),
            User.builder().id("2").name("Jane Smith").email("jane.smith@example.com").password("67890").build()
        );

        when(userRepository.findAll()).thenReturn(users);

        // When
        List<User> foundUsers = userService.getAllUsers();

        // Then
        assertNotNull(foundUsers);
        assertEquals(2, foundUsers.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void shouldUpdateUserSuccessfully() {
        // Given
        String userId = "1";
        User existingUser = User.builder()
            .id(userId)
            .name("John Doe")
            .email("john.doe@example.com")
            .password("12345")
            .build();

        User updatedUser = User.builder()
            .id(userId)
            .name("John Updated")
            .email("john.updated@example.com")
            .password("67890")
            .build();

        when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(any(User.class))).thenReturn(updatedUser);

        // When
        User result = userService.updateUser(userId, "John Updated", "john.updated@example.com", "67890");

        // Then
        assertNotNull(result);
        assertEquals("John Updated", result.getName());
        assertEquals("john.updated@example.com", result.getEmail());
        assertEquals("67890", result.getPassword());
        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void shouldThrowExceptionWhenUpdatingNonExistentUser() {
        // Given
        String userId = "1";
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(RuntimeException.class, () -> userService.updateUser(userId, "John Updated", null, null));
        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, times(0)).save(any(User.class));
    }
}
