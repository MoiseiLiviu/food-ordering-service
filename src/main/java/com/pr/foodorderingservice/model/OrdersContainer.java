package com.pr.foodorderingservice.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrdersContainer {

    public static final Map<Long, Order> orders = new HashMap<>();
}
