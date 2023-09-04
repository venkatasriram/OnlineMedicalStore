package com.capg.casestudy.onlinemedicalstore.controller;

import com.capg.casestudy.onlinemedicalstore.entity.UserDetails;
import com.capg.casestudy.onlinemedicalstore.serviceimpl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/user/")
public class UserDetailsController {
    @Autowired
    private UserDetailsServiceImpl userService;

    @PostMapping("addUser/")
    public UserDetails addUser(@RequestBody UserDetails user){
        return userService.addUser(user);
    }

    @GetMapping("viewUser/")
    public UserDetails viewUser(@RequestParam("userId") int id){
        return userService.showUser(id);
    }

    @GetMapping("viewAllUsers/")
    public List<UserDetails> viewAllUsers(){
        return userService.showAllUsers();
    }

    @DeleteMapping("deleteUser/")
    public void deleteUser(@RequestParam("userId") int id){
        userService.removeUser(id);
    }

    @PutMapping("updateUser")
    public UserDetails updateUser(@RequestBody UserDetails userDetails){
        return userService.updateUser(userDetails);
    }
}
