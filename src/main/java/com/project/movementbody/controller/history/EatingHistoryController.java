package com.project.movementbody.controller.history;

import com.project.movementbody.model.EatingHistory;
import com.project.movementbody.service.history.EatingHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EatingHistoryController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EatingHistoryService eatingHistoryService;

    @PostMapping("/api/v1/eatinghistory/add")
    public boolean addEatingHistory(@RequestBody EatingHistory eatingHistory) {
        return eatingHistoryService.insert(eatingHistory);
    }

}
