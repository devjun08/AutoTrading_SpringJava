package com.coinbot.coinbot.service.trading;

import com.coinbot.coinbot.controller.dto.BuyRequest;
import com.coinbot.coinbot.controller.dto.SellRequest;

public interface TradingService {
    void buy(String coinId, BuyRequest request);
    void sell(String coinId, SellRequest request);
}
