package com.example.sping11.controller;

import com.example.sping11.entity.ResponseDto;
import com.example.sping11.entity.User;
import com.example.sping11.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseDto<User> getUser(@PathVariable Integer id){
        return userService.getById(id);
    }


    @PostMapping()
    ResponseDto<User> addUser(@RequestBody User user){
        return userService.add(user);
    }


    @PutMapping()
    ResponseDto<User> updateUser(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    ResponseDto<User> deleteUser(@PathVariable Integer id){
        return userService.delete(id);
    }

    @PutMapping("/{id}/{fillingAmount}")
    ResponseDto<User> fillingUser(@PathVariable Integer id, @PathVariable Double fillingAmount){
        return userService.filling(id, fillingAmount);
    }

}
