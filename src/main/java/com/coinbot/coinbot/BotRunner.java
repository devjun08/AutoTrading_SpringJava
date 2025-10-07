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

    // ExchangeService 구현체(현재는 UpbitExchangeService)를 주입받아 실제 주문 실행에 사용할 의존성을 확보합니다.
    public BotRunner(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @Override
    public void run(String... args) throws Exception {
        // CommandLineRunner는 스프링 컨텍스트가 모두 올라온 직후 호출되므로, 애플리케이션 기동 시점에 전략 흐름을 빠르게 검증할 수 있습니다.
        System.out.println("--- 봇 전략 테스트 시작 ---");

        // KRW-BTC 시장에서 목표 가격(7천만 원)과 수량(0.01 BTC)을 매수하도록 액션을 구성합니다.
        BuyAction buyAction = new BuyAction(exchangeService, "KRW-BTC", 70000000.0, 0.01);

        // 설정한 가격 이상이 되면 buyAction을 실행하도록 트리거를 정의합니다.
        PriceTrigger priceTrigger = new PriceTrigger(exchangeService, "KRW-BTC", 70000000.0, buyAction);

        // 아직 외부 시세 연동이 없으므로 UpbitExchangeService에 더미 시세를 직접 주입해, 시나리오를 수동으로 검증합니다.
        MarketInfo marketInfo1 = new MarketInfo();
        marketInfo1.setCurrentPrice(65000000.0);
        ((UpbitExchangeService) exchangeService).setMarketInfo(marketInfo1);

        System.out.println("\n[시나리오 1] 현재 가격이 6500만원일 경우 (조건 미달)");
        // 조건이 충족되지 않으면 PriceTrigger는 액션을 수행하지 않고 상태만 출력합니다.
        priceTrigger.execute();

        // 가격을 목표 이상으로 올려 동일한 흐름을 다시 실행하며 성공 로그를 확인합니다.
        MarketInfo marketInfo2 = new MarketInfo();
        marketInfo2.setCurrentPrice(75000000.0);
        ((UpbitExchangeService) exchangeService).setMarketInfo(marketInfo2);

        System.out.println("\n[시나리오 2] 현재 가격이 7500만원일 경우 (조건 충족)");
        // 조건 충족 시에는 매수 액션이 실행되어 콘솔 로그로 주문 흐름을 확인할 수 있습니다.
        priceTrigger.execute();

        System.out.println("\n--- 봇 전략 테스트 종료 ---");
    }
}
