package com.fullstackprojects.recyclingapp.controller;

import com.fullstackprojects.recyclingapp.entity.Item;
import com.fullstackprojects.recyclingapp.service.ItemService;
import com.fullstackprojects.recyclingapp.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/items")
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) { this.itemService = itemService; }

//    @GetMapping("/secure/currentloans")
//    public List<ShelfCurrentLoansResponse> currentLoans(@RequestHeader(value="Authorization") String token)
//            throws Exception {
//        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
//        return itemService.currentLoans(userEmail);
//    }

//    @GetMapping("/secure/currentloans/count")
//    public int currentLoansCount(@RequestHeader(value="Authorization") String token) {
//        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
//        return itemService.currentLoansCount(userEmail);
//    }
//
//    @GetMapping("/secure/ischeckedout/byuser")
//    public Boolean checkoutBookByUser(@RequestHeader(value="Authorization") String token,
//                                      @RequestParam Long bookId) {
//        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
//        return itemService.checkoutBookByUser(userEmail, bookId);
//    }

//    @PutMapping("/secure/checkout")
//    public Item checkoutBook (@RequestHeader(value="Authorization") String token,
//                              @RequestParam Long bookId) throws Exception {
//        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
//        return itemService.checkoutBook(userEmail, bookId);
//    }
//
//    @PutMapping("/secure/return")
//    public void returnBook (@RequestHeader(value="Authorization") String token,
//                            @RequestParam Long bookId) throws Exception {
//        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
//        itemService.returnBook(userEmail, bookId);
//    }
//
//    @PutMapping("/secure/renew/loan")
//    public void renewLoan (@RequestHeader(value="Authorization") String token,
//                           @RequestParam Long bookId) throws Exception {
//        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
//        itemService.renewLoan(userEmail, bookId);
//    }
}
