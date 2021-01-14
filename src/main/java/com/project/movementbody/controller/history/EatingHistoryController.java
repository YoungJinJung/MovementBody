package com.project.movementbody.controller.history;

import com.project.movementbody.model.EatingHistory;
import com.project.movementbody.service.history.EatingHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EatingHistoryController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EatingHistoryService eatingHistoryService;

    @PostMapping("/api/v1/eatinghistory/add")
    public boolean addEatingHistory(@RequestBody List<EatingHistory> eatingHistoryList) {
        return eatingHistoryService.insert(eatingHistoryList);
    }

    @GetMapping("/api/v1/eatinghistory/read/{memberId}")
    public List<EatingHistory> readEatingHistory( @PathVariable String memberId) {
        return eatingHistoryService.read(memberId);
    }

    @PostMapping("/api/v1/eatinghistory/update")
    public boolean updateEatingHistory(@RequestBody EatingHistory eatingHistory) {
        return eatingHistoryService.update(eatingHistory);
    }

    @DeleteMapping("/api/v1/eatinghistory/delete")
    public boolean deleteEatingHistory(@RequestBody EatingHistory eatingHistory) {
        return eatingHistoryService.delete(eatingHistory);
    }

}
