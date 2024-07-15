package com.example.muddyteam_back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server")
public class StatusController {

    @GetMapping("/status")
    public ResponseEntity<String> checkStatus(){
        System.out.println("200");
        return ResponseEntity.ok("OK");
    }
}
