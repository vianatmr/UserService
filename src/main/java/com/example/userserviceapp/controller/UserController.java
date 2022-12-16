package com.example.userserviceapp.controller;

import com.example.userserviceapp.dto.MessageResponse;
import com.example.userserviceapp.dto.RoleRequest;
import com.example.userserviceapp.dto.RoleResponse;
import com.example.userserviceapp.dto.UserDTO;
import com.example.userserviceapp.entity.User;
import com.example.userserviceapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MessageResponse> addFilm(@RequestBody UserDTO request) {
        MessageResponse messageResponse = new MessageResponse();
        User user = userService.mapToEntity(request);
        User result = userService.addUser(user);
        if (result == null) {
            messageResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            messageResponse.setMessage("Failed to add film");
            return ResponseEntity.badRequest().body(messageResponse);
        } else {
            messageResponse.setStatus(HttpStatus.CREATED.value());
            messageResponse.setMessage("Add new film");
            messageResponse.setData(result);
            return ResponseEntity.ok().body(messageResponse);
        }
    }
    @PostMapping(value = "/add-role", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MessageResponse> createRole(@RequestBody RoleRequest roleRequest)
    {
        MessageResponse messageModel = new MessageResponse();
        RoleResponse roleResponse = userService.registerRole(roleRequest);
        if(roleResponse == null)
        {
            messageModel.setStatus(HttpStatus.BAD_REQUEST.value());
            messageModel.setMessage("Failed to create roles");
            return ResponseEntity.badRequest().body(messageModel);
        }
        else
        {
            messageModel.setStatus(HttpStatus.CREATED.value());
            messageModel.setMessage("Create new roles");
            messageModel.setData(roleResponse);
            return ResponseEntity.ok().body(messageModel);
        }
    }
}
