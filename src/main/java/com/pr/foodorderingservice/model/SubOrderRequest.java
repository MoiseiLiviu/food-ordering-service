package com.pr.foodorderingservice.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubOrderRequest {

    @JsonAlias("restaurant_id")
    private Long restaurantId;

    private List<Long> items = new ArrayList<>();

    private Integer priority;

    @JsonAlias("created_time")
    private Instant createdTime;

    @JsonAlias("max_wait")
    private Double maximumWaitTime;
}

