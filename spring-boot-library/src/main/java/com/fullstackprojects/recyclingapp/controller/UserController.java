package com.fullstackprojects.recyclingapp.controller;

import com.fullstackprojects.recyclingapp.entity.User;
import com.fullstackprojects.recyclingapp.requestmodels.AddUserRequest;
import com.fullstackprojects.recyclingapp.requestmodels.AdminQuestionRequest;
import com.fullstackprojects.recyclingapp.service.UserService;
import com.fullstackprojects.recyclingapp.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping("/secure/add/user")
//    public void postMessage(@RequestHeader(value="Authorization") String token,
//                            @RequestBody AddUserRequest userRequest) {
//        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
//        userService.addUser(userRequest);
//    }
//
//    @PutMapping("/secure/admin/message")
//    public void putMessage(@RequestHeader(value="Authorization") String token,
//                           @RequestBody AdminQuestionRequest adminQuestionRequest) throws Exception {
//        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
//        String admin = ExtractJWT.payloadJWTExtraction(token, "\"userType\"");
//        if (admin == null || !admin.equals("admin")) {
//            throw new Exception("Administration page only.");
//        }
//        userService.putMessage(adminQuestionRequest, userEmail);
//    }
}
