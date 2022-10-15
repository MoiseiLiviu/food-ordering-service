package com.pr.foodorderingservice.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
@ToString
public class Order {

    @JsonAlias("order_id")
    private Long id;

    @JsonAlias("orders")
    private List<SubOrderResponse> subOrderResponses;

    private static AtomicLong atomicLong = new AtomicLong();

    public Order(){
        this.id = atomicLong.incrementAndGet();
    }
}
