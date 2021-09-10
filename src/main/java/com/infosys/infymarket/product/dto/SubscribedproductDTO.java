package com.infosys.infymarket.product.dto;

import javax.validation.constraints.Min;

import com.infosys.infymarket.product.entity.Subscribedproduct;

public class SubscribedproductDTO {
	@Min(value = 1,message="Cannot be 0 or left empty")
	String buyerid;
	@Min(value = 1,message="Cannot be 0 or left empty")
	String prodid;
	@Min(value = 1,message="Cannot be 0 or left empty")
	int quantity;
	public String getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(String buyerid) {
		this.buyerid = buyerid;
	}
	public String getProdid() {
		return prodid;
	}
	public void setProdid(String prodid) {
		this.prodid = prodid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public SubscribedproductDTO(@Min(value = 1, message = "Cannot be 0 or left empty") String buyerid,
			@Min(value = 1, message = "Cannot be 0 or left empty") String prodid,
			@Min(value = 1, message = "Cannot be 0 or left empty") int quantity) {
		super();
		this.buyerid = buyerid;
		this.prodid = prodid;
		this.quantity = quantity;
	}
	public SubscribedproductDTO() {
		super();
		
	}
	
	       // Converts Entity into DTO
			public static SubscribedproductDTO valueOf(Subscribedproduct subproduct) {
				SubscribedproductDTO subscribedprodDTO = new SubscribedproductDTO();
				subscribedprodDTO.setBuyerid(subproduct.getBuyerid());
				subscribedprodDTO.setProdid(subproduct.getProdid());
				subscribedprodDTO.setQuantity(subproduct.getQuantity());
				return subscribedprodDTO;
			}
			
			//Converts DTO into Entity
			public Subscribedproduct createEntity() {
				Subscribedproduct subscribe= new Subscribedproduct();
				subscribe.setBuyerid(this.getBuyerid());
				subscribe.setProdid(this.getProdid());
				subscribe.setQuantity(this.getQuantity());
				return subscribe;
			}
			
			@Override
			public String toString() {
				return "SubscribedproductDTO [buyerid=" + buyerid + ", prodid=" + prodid + ", quantity=" + quantity
						+ "]";
			}
			
}			
	
	
	