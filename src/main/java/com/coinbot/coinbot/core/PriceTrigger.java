package com.coinbot.coinbot.core;

import com.coinbot.coinbot.service.ExchangeService;

// 특정 가격에 도달했을 때 동작하는 Trigger
public class PriceTrigger implements Trigger {

    private final ExchangeService exchangeService;
    private final String market;
    private final double targetPrice;
    private final Action action;

    public PriceTrigger(ExchangeService exchangeService, String market, double targetPrice, Action action) {
        this.exchangeService = exchangeService;
        this.market = market;
        this.targetPrice = targetPrice;
        this.action = action;
    }

    @Override
    public void execute() {
        if (evaluate()) {
            action.execute();
        }
    }

    @Override
    public boolean evaluate() {
        double currentPrice = exchangeService.getMarketInfo(market).getCurrentPrice();
        System.out.println("현재 가격: " + currentPrice + ", 목표 가격: " + targetPrice);
        return currentPrice >= targetPrice;
    }
}