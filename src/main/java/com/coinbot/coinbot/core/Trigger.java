package com.coinbot.coinbot.core;

// Action을 수행하 위한 조(예: 가격, 패턴, 비율)
public interface Trigger extends Command {
    // 조건을 평가하 충족 여부 반환하는 메서드
    boolean evaluate();
}