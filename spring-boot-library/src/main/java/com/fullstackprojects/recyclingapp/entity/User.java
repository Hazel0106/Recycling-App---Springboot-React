package com.fullstackprojects.recyclingapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Data
public class User {

    public User(){}

    public User(String name, String userEmail, String password, String city, String img) {
        this.name = name;
        this.userEmail = userEmail;
        this.password = password;
        this.city = city;
        this.img = img;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    //    @Size(min = 2, message = "Name should have at least 2 characters.")
    @Column(name = "name")
    private String name;

    @Column(name="user_email")
    private String userEmail;

    @Column(name = "password")
    private String password;

    @Column(name="city")
    private String city;

    @Column(name = "status")
    private Integer status;

    @Column(name = "createDate")
    private Date createDate;

    @Column(name = "img")
    private String img;

}
