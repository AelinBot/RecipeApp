package com.accenture.recipeapp.controller;

import com.accenture.recipeapp.TestData;
import com.accenture.recipeapp.dto.UserDto;
import com.accenture.recipeapp.entity.User;
import com.accenture.recipeapp.mapper.MapUserDtoToEntity;
import com.accenture.recipeapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RegistrationController.class)
class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private MapUserDtoToEntity mapUserDtoToEntity;

    @Test
    void registerPageTest() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }

    @Test
    void addUserWhenUserDoesNotExistTest() throws Exception {
        when(mapUserDtoToEntity.mapUserToEntity(any(UserDto.class))).thenReturn(TestData.getUser());
        when(userService.userExists(anyString())).thenReturn(false);
        when(userService.saveUserRegister(any(User.class))).thenReturn(TestData.getUser());

        mockMvc.perform(post("/register")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("username", "user")
                .param("password", "password"))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/login"));

        verify(userService, times(1)).saveUserRegister(any(User.class));
    }

    @Test
    void addUserWhenUserExistsTest() throws Exception {
        when(mapUserDtoToEntity.mapUserToEntity(any(UserDto.class))).thenReturn(TestData.getUser());
        when(userService.userExists(anyString())).thenReturn(true);
        when(userService.saveUserRegister(any(User.class))).thenReturn(null);

        mockMvc.perform(post("/register")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("username", "user")
                .param("password", "password"))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/login"));

        verify(userService, never()).saveUserRegister(any(User.class));
    }
}