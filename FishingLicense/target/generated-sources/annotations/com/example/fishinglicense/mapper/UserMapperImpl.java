package com.example.fishinglicense.mapper;

import com.example.fishinglicense.dto.UserRequest;
import com.example.fishinglicense.dto.UserResponse;
import com.example.fishinglicense.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-12T16:01:09+0100",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserRequest userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.firstName( userRequest.getFirstName() );
        user.lastName( userRequest.getLastName() );
        user.phone( userRequest.getPhone() );
        user.email( userRequest.getEmail() );

        return user.build();
    }

    @Override
    public UserResponse toResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setId( user.getId() );
        userResponse.setFirstName( user.getFirstName() );
        userResponse.setLastName( user.getLastName() );
        userResponse.setPhone( user.getPhone() );
        userResponse.setEmail( user.getEmail() );

        return userResponse;
    }
}
