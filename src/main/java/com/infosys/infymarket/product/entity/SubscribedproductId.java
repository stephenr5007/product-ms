package com.infosys.infymarket.product.entity;

import java.io.Serializable;
import java.util.Objects;

public class SubscribedproductId implements Serializable {
	String buyerid;
	String prodid;
	
	public SubscribedproductId()
	{
		super();
	}
	
	public SubscribedproductId(String buyerid,	String prodid)
	{
		this();
		this.buyerid=buyerid;
		this.prodid=prodid;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(buyerid, prodid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubscribedproductId other = (SubscribedproductId) obj;
		return Objects.equals(buyerid, other.buyerid) && Objects.equals(prodid, other.prodid);
	}
	

}
