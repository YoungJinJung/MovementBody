package com.project.movementbody.service.history;

import com.project.movementbody.repository.EatingHistoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EatingHistoryService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EatingHistoryRepository eatingHistoryRepository;
}
