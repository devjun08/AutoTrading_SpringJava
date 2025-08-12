package com.coinbot.coinbot.core;

// 봇의 모든 동작과 조건을 아우르는 최상위 인터페이스
public interface Command {
    //  봇이 수행할 명령을 정의하는 메서드
    void execute();
}