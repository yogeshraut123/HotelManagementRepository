package com.terrapay.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.terrapay.main.model.Menu_Quantity;

@Repository
public interface MenuQuantityRepository extends JpaRepository<Menu_Quantity, Integer> {

	public List<Menu_Quantity> findMenu_QuantityIdByMenuQuantityId(int menuQuantityId);

}
