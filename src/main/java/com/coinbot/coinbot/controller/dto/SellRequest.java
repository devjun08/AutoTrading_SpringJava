package com.coinbot.coinbot.controller.dto;

import lombok.Data;

@Data
public class SellRequest {
    private String market;
    private double price;
    private double volume;
}
