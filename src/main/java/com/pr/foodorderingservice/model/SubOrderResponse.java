package com.pr.foodorderingservice.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class SubOrderResponse {

    @JsonAlias("order_id")
    private Long orderId;

    @JsonAlias("restaurant_id")
    private Long restaurantId;

    @JsonAlias("estimated_waiting_time")
    private Double estimatedWaitingTime;

    @JsonAlias("created_time")
    private Instant createdTime;

    @JsonAlias("registered_time")
    private Instant registeredTime;
}
