package com.terrapay.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.terrapay.main.model.Menu_Master;
import com.terrapay.main.repository.Menu_MasterRepository;
import com.terrapay.main.service.Menu_MasterService;

@Service
public class Menu_MasterServiceImpl implements Menu_MasterService {

	@Autowired
	Menu_MasterRepository menu_masterRepository;

	@Override
	public void saveMenu(Menu_Master menu_Master) {

		menu_masterRepository.save(menu_Master);
	}

	@Override
	public List<Menu_Master> getAll() {

		List<Menu_Master> list = (List<Menu_Master>) menu_masterRepository.findAll();
		return list;
	}

	@Override
	public void updatedata(Menu_Master m) {

		menu_masterRepository.save(m);

	}

	@Override
	public void deleteMenu(Integer menuId) {

		menu_masterRepository.deleteById(menuId);

	}

}
