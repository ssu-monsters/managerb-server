/*package com.backend.server.controller;

import com.backend.server.domain.Promotion;
import com.backend.server.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recruit")
public class RecruitController {

    private final RecruitService recruitService;

    @Autowired
    public RecruitController(RecruitService recruitService) {
        this.recruitService = recruitService;
    }

   /* @PostMapping
    public Promotion getPromotionByStep(@RequestBody String step) {
        if (step.equals("WRITE_PROMOTION_POST")) {
            return recruitService.getPromotionByStep(step);
        } else {
            // Handle other cases or return null if needed
            return null;
        }
    }
}
*/