package com.terrapay.main.controller;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.terrapay.main.controller.MenuQuantityController;
import com.terrapay.main.model.Menu_Quantity;
import com.terrapay.main.service.MenuQuantityService;

@ExtendWith(MockitoExtension.class)
public class MenuQuantityControllerTest {

	@InjectMocks
	MenuQuantityController menuQuantityController;

	@Mock
	MenuQuantityService menuQuantityService;

	@Test
	public void testRegister() {
		Mockito.doNothing().when(menuQuantityService).saveMenuQuantity(Mockito.any());
		String res = menuQuantityController.register(new Menu_Quantity());
		assertTrue(true);
	}

	@Test
	public void testGetMenuQuantityBymenuQuantityId() {
		Mockito.when(menuQuantityService.findMenu_QuantityIdByMenuQuantityId(Mockito.anyInt()))
				.thenReturn(new Object());
		ResponseEntity<List<Menu_Quantity>> res = menuQuantityController.getMenuQuantityBymenuQuantityId(1);
		assertTrue(true);
	}

	@Test
	public void testUpdatedata() {
		Mockito.doNothing().when(menuQuantityService).updatedata(Mockito.any());
		String res = menuQuantityController.updatedata(new Menu_Quantity());
		assertTrue(true);
	}

	@Test
	public void testDeleteMenuQuantity() {
		Mockito.doNothing().when(menuQuantityService).deleteMenuQuantity(Mockito.anyInt());
		ResponseEntity<HttpStatus> res = menuQuantityController.deleteMenuQuantity(1);
		assertTrue(true);
	}

}
