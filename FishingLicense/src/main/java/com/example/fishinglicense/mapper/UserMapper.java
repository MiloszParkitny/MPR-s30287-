package com.example.fishinglicense.mapper;

import com.example.fishinglicense.dto.UserRequest;
import com.example.fishinglicense.dto.UserResponse;
import com.example.fishinglicense.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRequest userRequest);
    UserResponse toResponse(User user);
}
