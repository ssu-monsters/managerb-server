package com.backend.server.controller;

import com.backend.server.domain.Promotion;
import com.backend.server.request.PromotionResponse;
import com.backend.server.request.SignResponse;
import com.backend.server.service.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/promotion")
public class PromotionController {
    private final PromotionService promotionService;

    @GetMapping("/promotion/all")
    public ResponseEntity<List<PromotionResponse>> getAllPromotions() {
        List<PromotionResponse> promotions = promotionService.getAllPromotions();
        return new ResponseEntity<>(promotions, HttpStatus.OK);
    }
    @GetMapping("/promotion/get")
    public ResponseEntity<PromotionResponse> getpromotion(@RequestParam int organizationid) throws Exception {
        return new ResponseEntity<>( promotionService.getPromotion(organizationid), HttpStatus.OK);
    }
}