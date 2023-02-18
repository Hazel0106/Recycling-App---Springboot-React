package com.fullstackprojects.recyclingapp.requestmodels;

import lombok.Data;

@Data
public class AddItemRequest {

    private String title;

    private String description;

    private String category;

    private int status;
}
