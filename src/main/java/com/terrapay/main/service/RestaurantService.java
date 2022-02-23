package com.terrapay.main.service;

import com.terrapay.main.model.Restaurant;

public interface RestaurantService {

	public void saveRestaurant(Restaurant restaurant);

	public String findRestaurantByMobilenoAndEmail(Restaurant restaurant);

	public Object findRestaurantByPincode(int pincode);

	public void deleteRestaurant(Integer id);

	public void updatedata(Restaurant r);

	public Object findRestaurantById(int id);

}
