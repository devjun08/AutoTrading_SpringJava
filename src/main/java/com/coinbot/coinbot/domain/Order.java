package com.coinbot.coinbot.domain;

import lombok.Data;

@Data
public class Order {
    private String uuid; // 주문의 고유 ID
    private String market; // 거래 시장 (예: "KRW-BTC")
    private String side; // "bid" (매수), "ask" (매도)
    private double price; // 주문 가격
    private double volume; // 주문 수량
    private String state; // 주문 상태 (예: "done", "wait")
}