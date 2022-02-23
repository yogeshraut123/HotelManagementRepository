package com.terrapay.main.service;

import java.util.List;

import com.terrapay.main.model.Menu_Master;

public interface Menu_MasterService {

	public void saveMenu(Menu_Master menu_Master);

	public List<Menu_Master> getAll();

	public void updatedata(Menu_Master m);

	public void deleteMenu(Integer menuId);

}
