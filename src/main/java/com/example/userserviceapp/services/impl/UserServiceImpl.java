package com.example.userserviceapp.services.impl;

import com.example.userserviceapp.dto.RoleRequest;
import com.example.userserviceapp.dto.RoleResponse;
import com.example.userserviceapp.dto.UserDTO;
import com.example.userserviceapp.entity.Role;
import com.example.userserviceapp.entity.User;
import com.example.userserviceapp.repository.RoleRepository;
import com.example.userserviceapp.repository.UserRepository;
import com.example.userserviceapp.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public RoleResponse registerRole(RoleRequest roleRequest) {
        Role role = roleRequest.toRoles();

        try {
            roleRepository.save(role);
            return RoleResponse.build(role);
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    @Override
    public User addUser(User user) {

        User result = userRepository.save(user);
        return result;

    }
    ObjectMapper mapper = new ObjectMapper();
    @Override
    public User mapToEntity(UserDTO userDTO) {
        return mapper.convertValue(userDTO, User.class);
    }
}

