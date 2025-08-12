package com.coinbot.coinbot.service;

import com.coinbot.coinbot.domain.Order;
import com.coinbot.coinbot.domain.MarketInfo;
import org.springframework.stereotype.Service;

// ExchangeService 인터페이스의 Upbit 구현체
@Service
public class UpbitExchangeService implements ExchangeService {

    // 이 클래스는 실제 Upbit API를 호출하는 로직을 담게 됩니다.
    // 하지만 지금은 테스트를 위해 가상의 값들을 반환하도록 구현합니다.
    private MarketInfo marketInfo = new MarketInfo();

    @Override
    public Order placeBuyOrder(String market, double price, double volume) {
        // 실제 Upbit API를 사용하여 매수 주문을 발생시키는 로직이 들어갈 자리
        System.out.println("Upbit 매수 주문 실행: " + market + ", 가격: " + price + ", 수량: " + volume);
        return new Order();
    }

    @Override
    public Order placeSellOrder(String market, double price, double volume) {
        // 실제 Upbit API를 사용하여 매도 주문을 발생시키는 로직이 들어갈 자리
        System.out.println("Upbit 매도 주문 실행: " + market + ", 가격: " + price + ", 수량: " + volume);
        return new Order();
    }

    @Override
    public MarketInfo getMarketInfo(String market) {
        // 실제 Upbit API에서 시장 정보를 가져오는 로직이 들어갈 자리
        System.out.println("Upbit 시장 정보 조회: " + market);
        return marketInfo;
    }

    // 테스트를 위해 시장 정보를 설정하는 임시 메서드
    public void setMarketInfo(MarketInfo info) {
        this.marketInfo = info;
    }
}