package com.vitaliykairachka.phone_book.controller;

import com.vitaliykairachka.phone_book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApiController {
    @Autowired
    private UserService userService;
}
