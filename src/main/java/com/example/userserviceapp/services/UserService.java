package com.example.userserviceapp.services;

import com.example.userserviceapp.dto.RoleRequest;
import com.example.userserviceapp.dto.RoleResponse;
import com.example.userserviceapp.dto.UserDTO;
import com.example.userserviceapp.entity.User;


public interface UserService {
    RoleResponse registerRole(RoleRequest roleRequest);
    public User addUser(User user);
    User mapToEntity(UserDTO userDTO);
}
