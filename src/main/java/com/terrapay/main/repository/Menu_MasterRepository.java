package com.terrapay.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.terrapay.main.model.Menu_Master;

@Repository
public interface Menu_MasterRepository extends JpaRepository<Menu_Master, Integer> {

	
}
