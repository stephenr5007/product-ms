package com.infosys.infymarket.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.infosys.infymarket.product.entity.Subscribedproduct;

	public interface SubscribedproductRepository extends JpaRepository<Subscribedproduct, String>{
		List<Subscribedproduct> findByBuyerid(String buyerid);
		List<Subscribedproduct> findByprodid(String prodid);
		
	}

