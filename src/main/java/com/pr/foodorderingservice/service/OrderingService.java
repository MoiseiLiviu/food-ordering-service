package com.pr.foodorderingservice.service;

import com.pr.foodorderingservice.constants.RestaurantUrls;
import com.pr.foodorderingservice.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;


@Service
public class OrderingService {

    private static final RestTemplate restTemplate = new RestTemplate();

    public Order submitOrder(OrderRequest orderRequest) {
        List<CompletableFuture<SubOrderResponse>> completableFutures = new ArrayList<>();
        for (SubOrderRequest subOrderRequest : orderRequest.getSubOrderRequests()) {
            CompletableFuture<SubOrderResponse> completableFuture = CompletableFuture.supplyAsync(() -> submitSubOrderToRestaurant(subOrderRequest));
            completableFutures.add(completableFuture);
        }
        List<SubOrderResponse> subOrderResponses = completableFutures.stream()
                .map(CompletableFuture::join).collect(Collectors.toList());
        Order order = new Order();
        order.setSubOrderResponses(subOrderResponses);

        return order;
    }

    private SubOrderResponse submitSubOrderToRestaurant(SubOrderRequest subOrderRequest) {
        Restaurant restaurant = RestaurantContainer.restaurants.get(subOrderRequest.getRestaurantId());
        ResponseEntity<SubOrderResponse> response =
                restTemplate.postForEntity(restaurant.getAddress() + RestaurantUrls.ORDER, subOrderRequest, SubOrderResponse.class);

        return response.getBody();
    }
}
