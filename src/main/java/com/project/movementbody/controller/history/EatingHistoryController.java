package com.project.movementbody.controller.history;

import com.project.movementbody.model.EatingHistory;
import com.project.movementbody.service.history.EatingHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EatingHistoryController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EatingHistoryService eatingHistoryService;

    @PostMapping("/api/v1/eatinghistory/add")
    public boolean addEatingHistory(@RequestBody EatingHistory eatingHistory) {
        return eatingHistoryService.insert(eatingHistory);
    }

    @GetMapping("/api/v1/eatinghistory/read")
    public List<EatingHistory> readEatingHistory(String userId){
        return eatingHistoryService.selectByUserId(userId);
    }

    @PostMapping("/api/v1/eatinghistory/update")
    public boolean updateEatingHistory(@RequestBody EatingHistory eatingHistory) {
        return eatingHistoryService.insert(eatingHistory);
    }

}
