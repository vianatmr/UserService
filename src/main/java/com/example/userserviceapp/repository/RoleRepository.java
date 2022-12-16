package com.example.userserviceapp.repository;

import com.example.userserviceapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("SELECT r FROM Role r WHERE LOWER(r.roleName) LIKE LOWER(:roleName)")
    Role findByName(@Param("roleName") String roleName);
}
