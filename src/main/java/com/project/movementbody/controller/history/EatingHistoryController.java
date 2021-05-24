package com.project.movementbody.controller.history;

import com.project.movementbody.model.EatingHistory;
import com.project.movementbody.service.history.EatingHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Api(value = "EatingHistoryController V1")
public class EatingHistoryController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    final EatingHistoryService eatingHistoryService;

    public EatingHistoryController(EatingHistoryService eatingHistoryService) {
        this.eatingHistoryService = eatingHistoryService;
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
    @PostMapping("/eatinghistory/add")
    public boolean addEatingHistory(@RequestBody EatingHistory eatingHistory) {
        return eatingHistoryService.insert(eatingHistory);
    }

    @GetMapping("/eatinghistory/read/{userId}")
    public List<EatingHistory> getEatingHistory(@PathVariable String userId){
        return eatingHistoryService.selectByUserId(userId);
    }

    @PutMapping("/eatinghistory/update")
    public boolean updateEatingHistory(@RequestBody EatingHistory eatingHistory) {
        return eatingHistoryService.insert(eatingHistory);
    }

    @DeleteMapping("/eatinghistory/delete")
    public boolean deleteEatingHistory(@RequestBody EatingHistory eatingHistory) {
        return eatingHistoryService.delete(eatingHistory);
    }
}
