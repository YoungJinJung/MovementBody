package com.project.movementbody.controller.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRequestController {
    @GetMapping("/api/v1/test/success")
    public boolean testSuccess() {
        return true;
    }
}
