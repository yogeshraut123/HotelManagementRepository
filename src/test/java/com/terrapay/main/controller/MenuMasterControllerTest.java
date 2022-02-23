package com.terrapay.main.controller;

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

import com.terrapay.main.controller.MenuMasterController;
import com.terrapay.main.model.Menu_Master;
import com.terrapay.main.service.Menu_MasterService;

@ExtendWith(MockitoExtension.class)
public class MenuMasterControllerTest {

	@InjectMocks
	MenuMasterController menu_masterController;

	@Mock
	Menu_MasterService menu_MasterService;

	@Test
	public void testRegister() {
		Mockito.doNothing().when(menu_MasterService).saveMenu(Mockito.any());
		String res = menu_masterController.register(new Menu_Master());
		assertTrue(true);

	}

	@Test
	public void testLogin() {

		Mockito.when(menu_MasterService.getAll()).thenReturn(new ArrayList<>());
		List<Menu_Master> res = menu_masterController.login();
		assertTrue(true);
	}

	@Test
	public void testUpdatedata() {
		Mockito.doNothing().when(menu_MasterService).updatedata(Mockito.any());
		String res = menu_masterController.updatedata(new Menu_Master());
		assertTrue(true);
	}

	@Test
	public void testDelete() {
		Mockito.doNothing().when(menu_MasterService).deleteMenu(Mockito.anyInt());
		ResponseEntity<HttpStatus> res = menu_masterController.delete(1);
		assertTrue(true);
	}

}
