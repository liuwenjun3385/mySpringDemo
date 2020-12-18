package com.example.controller;

import com.example.service.IServices;
import com.example.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUser/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "getUser")
    public String GetUser(@PathVariable int id){
        //userService = new UserService();
        System.out.println("==========="+id);
        return userService.findAll(id).toString();
    }


}
