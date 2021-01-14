package com.project.movementbody.controller.test;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Api(value = "TestRequestController V1")
public class TestRequestController {
    @GetMapping("/test/success")
    public boolean testSuccess() {
        return true;
    }
}
