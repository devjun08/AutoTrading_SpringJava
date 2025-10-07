package com.coinbot.coinbot.controller;

import com.coinbot.coinbot.controller.dto.BuyRequest;
import com.coinbot.coinbot.controller.dto.SellRequest;
import com.coinbot.coinbot.service.trading.TradingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TradeController {

    private final TradingService tradingService;

    public TradeController(TradingService tradingService) {
        this.tradingService = tradingService;
    }

    @PostMapping("/{coinId}/buy")
    public ResponseEntity<Void> buy(@PathVariable String coinId,
                                    @RequestBody BuyRequest request) {
        tradingService.buy(coinId, request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{coinId}/sell")
    public ResponseEntity<Void> sell(@PathVariable String coinId,
                                     @RequestBody SellRequest request) {
        tradingService.sell(coinId, request);
        return ResponseEntity.ok().build();
    }
}
