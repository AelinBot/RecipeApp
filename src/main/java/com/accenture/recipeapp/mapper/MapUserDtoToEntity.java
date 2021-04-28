package com.accenture.recipeapp.mapper;

import com.accenture.recipeapp.dto.UserDto;
import com.accenture.recipeapp.entity.Role;
import com.accenture.recipeapp.entity.User;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class MapUserDtoToEntity {
    public User mapUserToEntity(UserDto userDto) {
        User userEntity = new User();
        userEntity.setId(userDto.getId());
        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setRoles(Collections.singleton(Role.USER));

        return userEntity;
    }
}
