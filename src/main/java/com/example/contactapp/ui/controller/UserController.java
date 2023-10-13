package com.example.contactapp.ui.controller;

import com.example.contactapp.service.UserService;
import com.example.contactapp.shared.dto.UserDto;
import com.example.contactapp.ui.model.request.UserDetailsRequestModel;
import com.example.contactapp.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("users") // http://localhost:8080/users

public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public String getUsers() {
        //read parameters
        //query to DB
        //return resource from DB to the client
        return "message form the getUsers method";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel user) {
        UserRest returnValue = new UserRest();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);
        return returnValue;
    }

    @PutMapping
    public String postUser() {
        return "message from postUser method";
    }

    @DeleteMapping
    public String deleteUser() {
        return "message from deleteUser method";
    }
}
