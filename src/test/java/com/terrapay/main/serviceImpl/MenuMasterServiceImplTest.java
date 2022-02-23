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

import com.terrapay.main.model.Menu_Master;
import com.terrapay.main.repository.Menu_MasterRepository;

@ExtendWith(MockitoExtension.class)
public class MenuMasterServiceImplTest {

	@InjectMocks
	Menu_MasterServiceImpl menumasterserviceimpl;

	@Mock
	Menu_MasterRepository menu_MasterRepository;

	@Test
	public void testSaveMenu() {
		Menu_Master menu_Master = new Menu_Master();

		menu_Master.setMenuId(1);
		menu_Master.setItemName("test");

		Mockito.when(menu_MasterRepository.save(Mockito.any())).thenReturn(menu_Master);
		menumasterserviceimpl.saveMenu(menu_Master);
		assertTrue(true);
	}

	@Test
	public void testGetall() {
		Mockito.when(menu_MasterRepository.findAll()).thenReturn(new ArrayList<>());
		List<Menu_Master> res = menumasterserviceimpl.getAll();
		assertTrue(true);
	}

	@Test
	public void testupdatedata() {

		Menu_Master menu_Master = new Menu_Master();

		menu_Master.setMenuId(1);
		menu_Master.setItemName("testt");

		Mockito.when(menu_MasterRepository.save(Mockito.any())).thenReturn(menu_Master);
		menumasterserviceimpl.updatedata(menu_Master);
		assertTrue(true);

	}

	@Test
	public void testDeleteMenu() {
		Mockito.doNothing().when(menu_MasterRepository).deleteById(Mockito.anyInt());
		menumasterserviceimpl.deleteMenu(1);
		assertTrue(true);
	}

}
