package com.terrapay.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.terrapay.main.encodedecode.Converter;

import com.terrapay.main.model.Restaurant;
import com.terrapay.main.repository.RestaurantRepository;
import com.terrapay.main.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantRepository restaurantRepository;

	@Override
	public void saveRestaurant(Restaurant restaurant) {

		String str = com.terrapay.main.encodedecode.Converter.encodepassword(restaurant.getPassword());
		restaurant.setPassword(str);

		restaurantRepository.save(restaurant);

	}

	@Override
	public List<Restaurant> findRestaurantByPincode(int pincode) {

		return restaurantRepository.findRestaurantByPincode(pincode);
	}

	@Override
	public List<Restaurant> findRestaurantById(int id) {

		return restaurantRepository.findRestaurantById(id);
	}

	@Override
	public void deleteRestaurant(Integer id) {

		restaurantRepository.deleteById(id);

	}

	@Override
	public void updatedata(Restaurant r) {

		restaurantRepository.save(r);

	}

	@Override
	public String findRestaurantByMobilenoAndEmail(Restaurant restaurant) {

		String login = null;

		Restaurant r = null;

		if (restaurant.getEmail() != null && !restaurant.getEmail().equalsIgnoreCase("")) {
			r = restaurantRepository.findRestaurantByEmail(restaurant.getEmail());
			System.out.println(restaurant.getEmail());

		} else if (restaurant.getMobileno() != 0l) {
			r = restaurantRepository.findRestaurantByMobileno(restaurant.getMobileno());
			System.out.println(restaurant.getMobileno());
		}
		if (r != null) {
			String password = Converter.decodepassword(r.getPassword());
			System.out.println(password);
			if (restaurant.getPassword().contains(password)) {
				login = "Successfully login";
			} else {

				login = "failed to login";
			}
		} else {
			login = "failed to login";
		}

		return login;

	}

}
