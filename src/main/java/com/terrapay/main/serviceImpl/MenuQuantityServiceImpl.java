package com.terrapay.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.terrapay.main.model.Menu_Quantity;
import com.terrapay.main.repository.MenuQuantityRepository;
import com.terrapay.main.service.MenuQuantityService;

@Service
public class MenuQuantityServiceImpl implements MenuQuantityService {

	@Autowired
	MenuQuantityRepository menuQuantityRepository;

	@Override
	public void saveMenuQuantity(Menu_Quantity menuquantity) {

		menuQuantityRepository.save(menuquantity);

	}

	@Override
	public List<Menu_Quantity> findMenu_QuantityIdByMenuQuantityId(int menuQuantityId) {

		return menuQuantityRepository.findMenu_QuantityIdByMenuQuantityId(menuQuantityId);
	}

	@Override
	public void deleteMenuQuantity(int menuQuantityId) {

		menuQuantityRepository.deleteById(menuQuantityId);
	}

	@Override
	public void updatedata(Menu_Quantity menuQuantity) {

		menuQuantityRepository.save(menuQuantity);
	}

}
