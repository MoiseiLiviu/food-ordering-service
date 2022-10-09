package com.pr.foodorderingservice.controller;

import com.pr.foodorderingservice.model.*;
import com.pr.foodorderingservice.service.OrderingService;
import com.pr.foodorderingservice.service.RatingService;
import com.pr.foodorderingservice.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class FoodOrderingController {

    private final RegistrationService registrationService;
    private final OrderingService orderingService;
    private final RatingService ratingService;

    @PostMapping("/register")
    public void registerRestaurant(@RequestBody Restaurant restaurant) {
        registrationService.registerRestaurant(restaurant);
    }

    @GetMapping("/menu")
    public MenuResponse getMenuForAllAvailableRestaurants() {
        return registrationService.getMenus();
    }

    @PostMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    public Order submitOrder(@RequestBody OrderRequest orderRequest) {
        return orderingService.submitOrder(orderRequest);
    }

    @PostMapping("/rating")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void submitRating(@RequestBody OrderRating orderRating){
        ratingService.submitRating(orderRating);
    }
}
