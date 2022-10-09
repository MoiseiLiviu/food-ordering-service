package com.pr.foodorderingservice.model;

import com.pr.foodorderingservice.model.Restaurant;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RestaurantContainer {

    public static final Map<Long, Restaurant> restaurants = new HashMap<>();
}
