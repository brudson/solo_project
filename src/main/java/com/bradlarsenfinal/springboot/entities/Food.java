package com.bradlarsenfinal.springboot.entities;

public class Food {
	
	private Integer foodId;
	private String name;
	private String vendorName;
	private String category;
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the vendorName
	 */
	public String getVendorName() {
		return vendorName;
	}
	/**
	 * @param vendorName the vendorName to set
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the foodId
	 */
	public Integer getFoodId() {
		return foodId;
	}
	/**
	 * @param foodId the foodId to set
	 */
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
}