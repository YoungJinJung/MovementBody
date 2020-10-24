package com.project.movementbody.controller.history;

import com.project.movementbody.service.history.EatingHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EatingHistroyController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EatingHistoryService eatingHistoryService;
}
