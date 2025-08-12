package com.coinbot.coinbot.core;

import com.coinbot.coinbot.service.ExchangeService;

// 매수 Action을 담당하는 클래스
public class BuyAction implements Action {

    private final ExchangeService exchangeService;
    private final String market;
    private final double price;
    private final double volume;

    public BuyAction(ExchangeService exchangeService, String market, double price, double volume) {
        this.exchangeService = exchangeService;
        this.market = market;
        this.price = price;
        this.volume = volume;
    }

    @Override
    public void execute() {
        exchangeService.placeBuyOrder(market, price, volume);
        System.out.println("매수 주문 실행 완료: " + market + ", 가격: " + price);
    }
}