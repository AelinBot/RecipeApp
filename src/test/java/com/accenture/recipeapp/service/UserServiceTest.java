package com.accenture.recipeapp.service;

import com.accenture.recipeapp.TestData;
import com.accenture.recipeapp.entity.User;
import com.accenture.recipeapp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @InjectMocks
    UserService userService;

    private User testUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        testUser = TestData.getUser();
    }

    @Test
    void loadUserByUsernameTest() {
        when(userRepository.findByUsername(anyString())).thenReturn(testUser);

        userService.loadUserByUsername(TestData.TEST_USERNAME);
        verify(userRepository, atLeastOnce()).findByUsername(anyString());
    }

    @Test
    void saveUserRegisterTest() {
        when(passwordEncoder.encode(anyString())).thenReturn(TestData.TEST_PASSWORD);
        when(userRepository.save(any(User.class))).thenReturn(testUser);

        User userSaved = userService.saveUserRegister(testUser);

        assertEquals(userSaved, testUser);
    }

    @Test
    void userExistsTest() {
        when(userRepository.existsByUsername(anyString())).thenReturn(true);
        assertTrue(userService.userExists(TestData.TEST_USERNAME));
    }

    @Test
    void getUserByUsernameTest() {
        when(userRepository.findByUsername(anyString())).thenReturn(testUser);

        userService.getUserByUsername(TestData.TEST_USERNAME);
        verify(userRepository, atLeastOnce()).findByUsername(anyString());
    }
}
