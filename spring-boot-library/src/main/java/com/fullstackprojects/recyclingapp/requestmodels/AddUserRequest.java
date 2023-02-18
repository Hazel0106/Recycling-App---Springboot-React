package com.fullstackprojects.recyclingapp.requestmodels;

import lombok.Data;

@Data
public class AddUserRequest {

    private String name;

    private String email;

    private String password;

    private String city;

//    private Integer status;

    private String img;
}
