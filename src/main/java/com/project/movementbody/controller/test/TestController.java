package com.project.movementbody.controller.test;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1")
@Api(value = "TestController V1")
public class TestController {

    @GetMapping
    public String index(Model model) {
        return "index";
    }
}
