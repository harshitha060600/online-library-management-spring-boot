package com.hk.onlineLibraryManagement.controllers;

import com.hk.onlineLibraryManagement.models.TransactionType;
import com.hk.onlineLibraryManagement.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/initiate")
    public String initiateTxn(@RequestParam("studentId") Long studentId,
                              @RequestParam("bookId") Long bookId,
                              @RequestParam("transactionType") TransactionType transactionType) throws Exception {
        return this.transactionService.initiateTxn(studentId,bookId,transactionType);
    }
}
