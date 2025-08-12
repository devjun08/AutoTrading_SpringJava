package com.coinbot.coinbot.domain;

import lombok.Data;

@Data
public class MarketInfo {
    private String market; // 거래 시장 (예: "KRW-BTC")
    private double currentPrice; // 현재 가격
    private double highPrice; // 24시간 최고가
    private double lowPrice; // 24시간 최저가
    // 필요에 따라 더 많은 필드를 추가할 수 있습니다.
}