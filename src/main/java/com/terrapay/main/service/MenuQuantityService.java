package com.terrapay.main.service;

import com.terrapay.main.model.Menu_Quantity;

public interface MenuQuantityService {

	public void saveMenuQuantity(Menu_Quantity menuquantity);

	public Object findMenu_QuantityIdByMenuQuantityId(int menuQuantityId);

	public void deleteMenuQuantity(int menuQuantityId);

	public void updatedata(Menu_Quantity menuQuantity);

}
