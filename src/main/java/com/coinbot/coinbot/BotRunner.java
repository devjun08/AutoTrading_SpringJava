package com.coinbot.coinbot;

import com.coinbot.coinbot.core.BuyAction;
import com.coinbot.coinbot.core.PriceTrigger;
import com.coinbot.coinbot.service.ExchangeService;
import com.coinbot.coinbot.service.UpbitExchangeService;
import com.coinbot.coinbot.domain.MarketInfo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BotRunner implements CommandLineRunner {

    private final ExchangeService exchangeService;

    // Spring이 ExchangeService 구현체(UpbitExchangeService)를 자동으로 주입해줍니다.
    public BotRunner(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- 봇 전략 테스트 시작 ---");

        // 1. 매수 Action 정의: BTC-KRW 시장에서 7000만원에 0.01 BTC를 매수하는 동작
        BuyAction buyAction = new BuyAction(exchangeService, "KRW-BTC", 70000000.0, 0.01);

        // 2. 가격 Trigger 정의: 가격이 7000만원 이상일 때 위에서 정의한 buyAction을 실행하는 조건
        PriceTrigger priceTrigger = new PriceTrigger(exchangeService, "KRW-BTC", 70000000.0, buyAction);

        // 3. 봇 전략 실행
        // 현재 가격을 6500만원으로 가정하고 시나리오를 진행합니다.

        // UpbitExchangeService 클래스에 setMarketInfo 메서드가 필요합니다.
        // 현재 가격을 6500만원으로 설정합니다.
        MarketInfo marketInfo1 = new MarketInfo();
        marketInfo1.setCurrentPrice(65000000.0);

        // exchangeService가 UpbitExchangeService의 인스턴스라고 가정하고, 캐스팅하여 메서드를 호출합니다.
        // (이 부분은 테스트를 위한 임시 방편입니다. 실제 코드에서는 이러한 방식 대신 Mocking을 사용하는 것이 더 좋습니다.)
        ((UpbitExchangeService) exchangeService).setMarketInfo(marketInfo1);

        System.out.println("\n[시나리오 1] 현재 가격이 6500만원일 경우 (조건 미달)");
        priceTrigger.execute(); // -> "현재 가격: 6.5E7, 목표 가격: 7.0E7" 출력 후 종료

        // 4. 가격이 상승하여 7500만원이 되었다고 가정하고 다시 실행합니다.
        MarketInfo marketInfo2 = new MarketInfo();
        marketInfo2.setCurrentPrice(75000000.0);
        ((UpbitExchangeService) exchangeService).setMarketInfo(marketInfo2);

        System.out.println("\n[시나리오 2] 현재 가격이 7500만원일 경우 (조건 충족)");
        priceTrigger.execute(); // -> "현재 가격: 7.5E7, 목표 가격: 7.0E7" 출력
        // -> "Upbit 매수 주문 실행: KRW-BTC, 가격: 7.0E7, 수량: 0.01" 출력
        // -> "매수 주문 실행 완료: KRW-BTC, 가격: 7.0E7" 출력

        System.out.println("\n--- 봇 전략 테스트 종료 ---");
    }
}