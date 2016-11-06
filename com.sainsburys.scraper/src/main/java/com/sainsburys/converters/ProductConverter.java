package com.sainsburys.converters;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.sainsburys.model.PageData;
import com.sainsburys.model.PageProduct;
import com.sainsburys.model.ProductPageData;
import com.sainsburys.model.ProductViewContainer;
import com.sainsburys.model.ProductViewModel;
import com.sainsburys.model.ViewModel;
@Component
public class ProductConverter implements PageDataConverter {

	@Override
	public ViewModel toViewModel(PageData pageData) {
		
		ProductViewContainer container = new ProductViewContainer();
		BigDecimal total = BigDecimal.ZERO;
		ArrayList<ProductViewModel> viewProductList = new ArrayList<ProductViewModel>(((ProductPageData)pageData).getProducts().size());
		
		for(PageProduct pageProduct:((ProductPageData)pageData).getProducts()){
			ProductViewModel viewProduct =  new ProductViewModel();
			
			viewProduct.setDescription(pageProduct.getDescription());
			viewProduct.setTitle(pageProduct.getTitle());
			viewProduct.setUnitPrice(new BigDecimal(pageProduct.getUnitPrice()).setScale(2, RoundingMode.HALF_EVEN));
			viewProduct.setSize(new BigDecimal(pageProduct.getSize()).divide(new BigDecimal(1024)).setScale(2,RoundingMode.HALF_EVEN) + "kb");
			
			viewProductList.add(viewProduct);
			total= total.add(new BigDecimal(pageProduct.getUnitPrice()));
			
			
		}
		container.setResults(viewProductList);
		container.setTotal(total);
		
		return container;
	}

	


}
