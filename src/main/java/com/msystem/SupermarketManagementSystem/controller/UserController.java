package com.msystem.SupermarketManagementSystem.controller;

import com.msystem.SupermarketManagementSystem.dto.ApiResponse;
import com.msystem.SupermarketManagementSystem.model.User;
import com.msystem.SupermarketManagementSystem.service.UserService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public ApiResponse list() {
        return userService.findAllUsers();
    }

    @PostMapping("/save")
    public ApiResponse save(@RequestBody User user) {
        return userService.addNewUser(user);
    }

//    @PutMapping("/update")
//    public ApiResponse update(@RequestBody User user) {
//        return userService.updateUser(user);
//    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable(name = "id") Integer userId) {
        return userService.deleteUserById(userId);
    }

//    @GetMapping("/getBy/{id}")
//    @ResponseBody
//    public ApiResponse getById(@PathVariable(name = "id") Integer userId) {
//        return userService.getUserById(userId);
//    }

//    @GetMapping("/getOrdersByUserId/{id}")
//    public ApiResponse getOrdersByUserId(@PathVariable(name = "id") Integer userId) {
//        return userService.getOrdersByUserId(userId);
//    }
}


