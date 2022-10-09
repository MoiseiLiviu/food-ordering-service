package com.pr.foodorderingservice.service;

import com.pr.foodorderingservice.model.RestaurantContainer;
import com.pr.foodorderingservice.model.MenuResponse;
import com.pr.foodorderingservice.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    public void registerRestaurant(Restaurant restaurant) {
        RestaurantContainer.restaurants.put(restaurant.getRestaurantId(), restaurant);
    }

    public MenuResponse getMenus() {
        MenuResponse menuResponse = new MenuResponse();
        menuResponse.setRestaurants(RestaurantContainer.restaurants.size());
        menuResponse.setRestaurantData((List<Restaurant>) RestaurantContainer.restaurants.values());

        return menuResponse;
    }
}
