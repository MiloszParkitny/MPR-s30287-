package com.example.fishinglicense.dto;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
}
