package com.pr.foodorderingservice.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class OrderRequest {

    @JsonAlias("client_id")
    private Long clientId;

    private List<SubOrderRequest> subOrderRequests;
}
