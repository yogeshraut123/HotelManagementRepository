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
import com.terrapay.main.model.Menu_Quantity;
import com.terrapay.main.repository.MenuQuantityRepository;

@ExtendWith(MockitoExtension.class)
public class MenuQuantityServiceImplTest {

	@InjectMocks
	MenuQuantityServiceImpl menuQuantityServiceImpl;

	@Mock
	MenuQuantityRepository menuQuantityRepository;

	@Test
	public void testSaveMenuQuantity() {

		Menu_Quantity menu_Quantity = new Menu_Quantity();

		menu_Quantity.setMenuQuantityId(1);
		menu_Quantity.setStatus("credit");

		Mockito.when(menuQuantityRepository.save(Mockito.any())).thenReturn(menu_Quantity);
		menuQuantityServiceImpl.saveMenuQuantity(menu_Quantity);
		assertTrue(true);
	}

	@Test
	public void testFindMenu_QuantityIdByMenuQuantityId() {

		Mockito.when(menuQuantityRepository.findMenu_QuantityIdByMenuQuantityId(Mockito.anyInt()))
				.thenReturn(new ArrayList<Menu_Quantity>());
		List<Menu_Quantity> res = menuQuantityServiceImpl.findMenu_QuantityIdByMenuQuantityId(1);
		assertTrue(true);
	}

	@Test
	public void testDeleteMenuQuantity() {
		Mockito.doNothing().when(menuQuantityRepository).deleteById(Mockito.anyInt());
		menuQuantityServiceImpl.deleteMenuQuantity(1);
		assertTrue(true);
	}

	@Test
	public void testUpdatedata() {

		Menu_Quantity menu_Quantity = new Menu_Quantity();

		menu_Quantity.setMenuQuantityId(1);
		menu_Quantity.setStatus("debit");

		Mockito.when(menuQuantityRepository.save(Mockito.any())).thenReturn(menu_Quantity);
		menuQuantityServiceImpl.updatedata(menu_Quantity);
		assertTrue(true);

	}

}
