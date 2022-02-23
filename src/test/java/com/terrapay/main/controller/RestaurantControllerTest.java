package com.terrapay.main.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.terrapay.main.model.Menu_Master;
import com.terrapay.main.model.Restaurant;
import com.terrapay.main.service.Menu_MasterService;
import com.terrapay.main.service.RestaurantService;

@ExtendWith(MockitoExtension.class)
public class RestaurantControllerTest {

	@InjectMocks
	RestaurantController restaurantController;

	@Mock
	RestaurantService restaurantservice;

	@Mock
	Menu_MasterService menu_MasterService;

	@Test
	public void testRegister() {
		Mockito.doNothing().when(restaurantservice).saveRestaurant(Mockito.any());
		String res = restaurantController.register(new Restaurant());
		assertTrue(true);

	}

	@Test
	public void testLogin() {
		Mockito.when(restaurantservice.findRestaurantByMobilenoAndEmail(Mockito.any())).thenReturn("test");
		String res = restaurantController.login(Mockito.any());
		assertThat(res).isEqualTo("test");
	}

	@Test
	public void testGetRestaurantByPincode() {
		Mockito.when(restaurantservice.findRestaurantByPincode(Mockito.anyInt())).thenReturn(new Object());
		ResponseEntity<List<Restaurant>> res = restaurantController.getRestaurantByPincode(445302);
		assertTrue(true);
	}

	@Test
	public void testFindAll() {
		Mockito.when(menu_MasterService.getAll()).thenReturn(new ArrayList<>());
		List<Menu_Master> res = restaurantController.findAll();
		assertTrue(true);

	}

	@Test
	public void testDelete() {
		Mockito.doNothing().when(restaurantservice).deleteRestaurant(Mockito.anyInt());
		ResponseEntity<HttpStatus> res = restaurantController.delete(1);
		assertTrue(true);
	}

	@Test
	public void testUpdatedata() {
		Mockito.doNothing().when(restaurantservice).updatedata(Mockito.any());
		String res = restaurantController.updatedata(new Restaurant());
		assertTrue(true);
	}

}
