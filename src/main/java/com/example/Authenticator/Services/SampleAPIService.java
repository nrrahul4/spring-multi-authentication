package com.example.Authenticator.Services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SampleAPIService {

    @GetMapping("/getSample")
    public String getSample() {
        return "Hello, You reached.";
    }

    @GetMapping("/getNoAuth")
    public String getNoAuth() {
        return "Hello, You are on no auth.";
    }
}
