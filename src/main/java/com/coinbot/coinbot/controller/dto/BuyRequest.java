package com.coinbot.coinbot.controller.dto;

import lombok.Data;

@Data
public class BuyRequest {
    private String market;
    private double price;
    private double volume;
}

