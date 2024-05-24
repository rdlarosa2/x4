package com.nisum.usuario.rest;

import com.nisum.usuario.service.UserService ;
import com.nisum.usuario.entity.User;
import com.nisum.usuario.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {


    private UserService userService;

    @Autowired
    public UserRestController(UserService theUserService) {
        this.userService = theUserService;
    }

    @GetMapping("/users")
    public List<UserVO> findAll() {
        return userService.findAll();
    }


    @GetMapping("/users/{userId}")
    public UserVO getUserById(@PathVariable("userId") Integer userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/users")
    public UserVO save(@RequestBody UserVO theUser) {

        return userService.save(theUser);
    }

}
