package com.ask.pk.myskill.pojo;

public class ProductDetails {
	
	private String row;
	private String column;
	private String availableQty;
	
	public ProductDetails(String row, String column, String availableQty) {
		super();
		this.row = row;
		this.column = column;
		this.availableQty = availableQty;
	}

	/**
	 * @return the row
	 */
	public String getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(String row) {
		this.row = row;
	}

	/**
	 * @return the column
	 */
	public String getColumn() {
		return column;
	}

	/**
	 * @param column the column to set
	 */
	public void setColumn(String column) {
		this.column = column;
	}

	/**
	 * @return the availableQty
	 */
	public String getAvailableQty() {
		return availableQty;
	}

	/**
	 * @param availableQty the availableQty to set
	 */
	public void setAvailableQty(String availableQty) {
		this.availableQty = availableQty;
	}
	
	

}
