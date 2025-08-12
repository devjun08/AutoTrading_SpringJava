package com.coinbot.coinbot.service;

import com.coinbot.coinbot.domain.Order;
import com.coinbot.coinbot.domain.MarketInfo;

// 여러 거래소에 대응하기 위한 인터페이스
public interface ExchangeService {
    // 매수 주문
    Order placeBuyOrder(String market, double price, double volume);

    // 매도 주문
    Order placeSellOrder(String market, double price, double volume);

    // 현재 시장 정보 조회
    MarketInfo getMarketInfo(String market);
}