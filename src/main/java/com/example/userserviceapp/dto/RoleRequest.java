package com.example.userserviceapp.dto;

import com.example.userserviceapp.entity.Role;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RoleRequest {
    @NotEmpty(message = "Role name is required.")
    private String roleName;

    public Role toRoles() {
        return Role.builder()
                .roleName(this.roleName)
                .build();
    }
}
