package com.sainsburys.model;

import java.util.ArrayList;
import java.util.List;

/**
 * object to contain the product data from the HTML
 * @author leeharris
 *
 */
public class ProductPageData extends PageData {

	private List<PageProduct> products;

	public List<PageProduct> getProducts() {
	
		return products;
	}

	public void setProducts(List<PageProduct> products) {
		this.products = products;
	}
	
	
	
}
