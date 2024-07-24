package com.example.project.uber.uberApi.dto;

import com.example.project.uber.uberApi.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String name;
    private String email;
    private Set<Role> role;
}
