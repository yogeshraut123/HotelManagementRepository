package com.terrapay.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.terrapay.main.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

	public List<Restaurant> findRestaurantByPincode(int pincode);

	public Restaurant findRestaurantByEmail(String email);

	public Restaurant findRestaurantByMobileno(long mobileno);

	public List<Restaurant> findRestaurantById(int id);

}
