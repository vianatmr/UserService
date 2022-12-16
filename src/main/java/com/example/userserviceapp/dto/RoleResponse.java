package com.example.userserviceapp.dto;

import com.example.userserviceapp.entity.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleResponse {
    private Integer role_Id;
    private String name;

    public static RoleResponse build(Role role) {
        return RoleResponse.builder()
                .role_Id(role.getRole_id())
                .name(String.valueOf(role.getRoleName()))
                .build();
    }
}
