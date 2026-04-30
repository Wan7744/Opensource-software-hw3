package com.example.restaurant_service.controller;

import com.example.restaurant_service.dto.AiStrategyResponse;
import com.example.restaurant_service.service.AiStrategyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AiStrategyController {

    private final AiStrategyService aiStrategyService;

    @GetMapping("/business-strategy")
    public AiStrategyResponse analyzeBusinessStrategy() {
        String result = aiStrategyService.analyzeBusinessStrategy();
        return new AiStrategyResponse(result);
    }
}