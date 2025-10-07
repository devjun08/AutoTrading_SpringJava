package com.coinbot.coinbot.service.trading;

import com.coinbot.coinbot.controller.dto.BuyRequest;
import com.coinbot.coinbot.controller.dto.SellRequest;
import com.coinbot.coinbot.service.ExchangeService;
import org.springframework.stereotype.Service;

@Service
public class TradingServiceImpl implements TradingService {

    private final ExchangeService exchangeService;

    public TradingServiceImpl(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @Override
    public void buy(String coinId, BuyRequest request) {
        exchangeService.placeBuyOrder(request.getMarket(), request.getPrice(), request.getVolume());
        // 혹은 PriceTrigger/BuyAction 조합
    }

    @Override
    public void sell(String coinId, SellRequest request) {
        exchangeService.placeSellOrder(request.getMarket(), request.getPrice(), request.getVolume());
    }
}
