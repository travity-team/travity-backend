package com.trip.tripinworld.domain.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ChatController {
    @GetMapping("/test")
    public String test() {
        return "docker setting success";
    }
}