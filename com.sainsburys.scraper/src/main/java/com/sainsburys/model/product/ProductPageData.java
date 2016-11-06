package com.sainsburys.model.product;

import java.util.List;

import com.sainsburys.model.PageData;

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
