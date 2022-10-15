package com.pr.foodorderingservice.service;

import com.pr.foodorderingservice.model.MenuResponse;
import com.pr.foodorderingservice.model.Restaurant;
import com.pr.foodorderingservice.model.RestaurantContainer;
import org.springframework.stereotype.Service;


@Service
public class RegistrationService {

    public void registerRestaurant(Restaurant restaurant) {
        RestaurantContainer.restaurants.put(restaurant.getRestaurantId(), restaurant);
    }

    public MenuResponse getMenus() {
        MenuResponse menuResponse = new MenuResponse();
        menuResponse.setRestaurants(RestaurantContainer.restaurants.size());
        menuResponse.setRestaurantData(RestaurantContainer.restaurants.values().stream().toList());

        return menuResponse;
    }
}
