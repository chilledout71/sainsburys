package com.sainsburys.model.product;

import java.math.BigDecimal;
import java.util.List;

import com.sainsburys.model.ViewModel;

public class ProductViewContainer extends ViewModel {
	
	private List<ProductViewModel> results;
	private BigDecimal total;

	public List<ProductViewModel> getResults() {
	
		return results;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public void setResults(List<ProductViewModel> results) {
		this.results = results;
	}

	
}
