package com.infosys.infymarket.product.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.infosys.infymarket.product.dto.SubscribedproductDTO;
import com.infosys.infymarket.product.entity.Subscribedproduct;
import com.infosys.infymarket.product.exception.InfymarketException;
import com.infosys.infymarket.product.repository.SubscribedproductRepository;

@Service
public class SubscribedProdService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	SubscribedproductRepository subscribedprodrepo;
	
	//Get subscribed product of buyer
	public List<SubscribedproductDTO> getByBuyerid(@PathVariable String buyerid) throws InfymarketException{

		logger.info("Products for the buyer with id {}", buyerid);

		Iterable<Subscribedproduct> sub = subscribedprodrepo.findByBuyerid(buyerid);
		List<SubscribedproductDTO> subscribedprodDTO = new ArrayList<SubscribedproductDTO>();

		sub.forEach(subs -> {
			subscribedprodDTO.add(SubscribedproductDTO.valueOf(subs));
		});
		if(subscribedprodDTO.isEmpty())
			throw new InfymarketException("Service.EMPTY_BUYER_PRODUCTS");
		return subscribedprodDTO;
	}
	
	//Get all subscribed products
	public List<SubscribedproductDTO> getAllSubProduct() throws InfymarketException{

		Iterable<Subscribedproduct> subs = subscribedprodrepo.findAll();
		List<SubscribedproductDTO> subscribedprodDTOs = new ArrayList<>();

		subs.forEach(subpro -> {
			SubscribedproductDTO subscribedprodDTO = SubscribedproductDTO.valueOf(subpro);
			subscribedprodDTOs.add(subscribedprodDTO);
		});
		if(subscribedprodDTOs.isEmpty())
			throw new InfymarketException("Service.NO_SUBSCRIBED_PRODUCTS");
		logger.info("Subscribed Product Details : {}", subscribedprodDTOs);
		return subscribedprodDTOs;
	}
	
	public void createSubscribedProduct(SubscribedproductDTO subscribeProdDTO) throws InfymarketException {
		logger.info("Creation request for customer {} with data {}", subscribeProdDTO);
		Subscribedproduct subscribe = null;
//		if(subscribeProdDTO.getBuyerid() != null) {
//			subscribe = subscribeProdDTO.createEntity();	
//		}
//		System.out.println("wishlist" + subscribe);
		subscribe = subscribeProdDTO.createEntity();	
		if (subscribe != null) {
			subscribedprodrepo.save(subscribe);
		} else {
			throw new InfymarketException("Service.NO_WISHLIST");
		}

	}
	
}
