package com.backend.server.controller;

import com.backend.server.domain.Promotion;
import com.backend.server.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/promotion")
public class PromotionController {
    private final PromotionService promotionService;

    @Autowired
    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @PostMapping
    public ResponseEntity<Promotion> getPromotionByOrganizationId(@RequestBody Map<String, String> requestBody) {
        String organizationId = requestBody.get("organizationId");
        Promotion promotion = promotionService.getPromotionByOrganizationId(organizationId);
        if (promotion != null) {
            return ResponseEntity.ok(promotion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
