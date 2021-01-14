package com.project.movementbody.controller.history;

import com.project.movementbody.service.history.EatingHistoryService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Api(value = "EatingHistoryController V1")
public class EatingHistoryController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EatingHistoryService eatingHistoryService;
}
