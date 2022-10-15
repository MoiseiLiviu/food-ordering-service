package com.pr.foodorderingservice.service;

import com.pr.foodorderingservice.constants.RestaurantUrls;
import com.pr.foodorderingservice.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RatingService {

    private static final RestTemplate restTemplate = new RestTemplate();

    public static Double foodOrderingServiceRating;

    public void submitRating(OrderRating orderRating) {

        for (SubOrderRatingRequest subOrderRatingRequest : orderRating.getOrders()) {
            submitRatingToSpecificRestaurant(subOrderRatingRequest);
        }
    }

    @Async
    public void submitRatingToSpecificRestaurant(SubOrderRatingRequest subOrderRatingRequest) {

        Restaurant restaurant = RestaurantContainer.restaurants.get(subOrderRatingRequest.getRestaurantId());
        ResponseEntity<SubOrderRatingResponse> response =
                restTemplate.postForEntity(restaurant.getAddress() + RestaurantUrls.RATING, subOrderRatingRequest, SubOrderRatingResponse.class);

        SubOrderRatingResponse subOrderRatingResponse = response.getBody();
        assert subOrderRatingResponse != null;
        restaurant.setRating(subOrderRatingResponse.getRestaurantAvgRating());
        foodOrderingServiceRating =
                RestaurantContainer.restaurants.values().stream().mapToDouble(Restaurant::getRating).sum() / RestaurantContainer.restaurants.size();

    }
}
