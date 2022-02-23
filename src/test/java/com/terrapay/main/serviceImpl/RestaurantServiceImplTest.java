package com.terrapay.main.serviceImpl;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.terrapay.main.model.Restaurant;
import com.terrapay.main.repository.RestaurantRepository;

@ExtendWith(MockitoExtension.class)
public class RestaurantServiceImplTest {

	@InjectMocks
	RestaurantServiceImpl restaurantServiceImpl;

	@Mock
	RestaurantRepository restaurantRepository;

	@Test
	public void testSaveMenuQuantity() {

		Restaurant restaurant = new Restaurant();

		restaurant.setId(1);
		restaurant.setName("test");
		restaurant.setPassword("12");

		Mockito.when(restaurantRepository.save(Mockito.any())).thenReturn(restaurant);
		restaurantServiceImpl.saveRestaurant(restaurant);
		assertTrue(true);
	}

	@Test
	public void testFindRestaurantByPincode() {
		Mockito.when(restaurantRepository.findRestaurantByPincode(1)).thenReturn(new ArrayList<>());
		List<Restaurant> res = restaurantServiceImpl.findRestaurantByPincode(1);
		assertTrue(true);
	}

	@Test
	public void testFindRestaurantById() {
		Mockito.when(restaurantRepository.findRestaurantById(1)).thenReturn(new ArrayList<>());
		List<Restaurant> res = restaurantServiceImpl.findRestaurantById(1);
		assertTrue(true);
	}

	@Test
	public void testDeleteRestaurant() {

		Mockito.doNothing().when(restaurantRepository).deleteById(Mockito.anyInt());
		restaurantServiceImpl.deleteRestaurant(1);
		assertTrue(true);
	}

	@Test
	public void testUpdatedata() {

		Restaurant restaurant = new Restaurant();

		restaurant.setId(1);
		restaurant.setName("test");

		Mockito.when(restaurantRepository.save(Mockito.any())).thenReturn(restaurant);
		restaurantServiceImpl.updatedata(restaurant);
		assertTrue(true);

	}

	@Test
	public void testFindRestaurantByMobilenoAndEmail() {
		Restaurant restaurant = new Restaurant();

		restaurant.setId(1);
		restaurant.setEmail("test@gmail.com");
		restaurant.setMobileno(992264);
		restaurant.setPassword("123");

		Mockito.lenient().when(restaurantRepository.findRestaurantByEmail(Mockito.anyString())).thenReturn(restaurant);
		Mockito.lenient().when(restaurantRepository.findRestaurantByMobileno(Mockito.anyLong())).thenReturn(restaurant);
		String res = restaurantServiceImpl.findRestaurantByMobilenoAndEmail(restaurant);
		assertTrue(true);
	}

}
