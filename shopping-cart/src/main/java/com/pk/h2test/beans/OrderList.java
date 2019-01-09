package com.pk.h2test.beans;

public class OrderList {

	private String orderid;
	
	private String purchaseDate;
	
	private String qty;

	private String pricetotal;

	public OrderList() {
		super();
	}

	/**
	 * @return the orderid
	 */
	public String getOrderid() {
		return orderid;
	}

	/**
	 * @param orderid the orderid to set
	 */
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	/**
	 * @return the purchaseDate
	 */
	public String getPurchaseDate() {
		return purchaseDate;
	}

	/**
	 * @param purchaseDate the purchaseDate to set
	 */
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	/**
	 * @return the qty
	 */
	public String getQty() {
		return qty;
	}

	/**
	 * @param qty the qty to set
	 */
	public void setQty(String qty) {
		this.qty = qty;
	}

	/**
	 * @return the pricetotal
	 */
	public String getPricetotal() {
		return pricetotal;
	}

	/**
	 * @param pricetotal the pricetotal to set
	 */
	public void setPricetotal(String pricetotal) {
		this.pricetotal = pricetotal;
	}

	
	
}