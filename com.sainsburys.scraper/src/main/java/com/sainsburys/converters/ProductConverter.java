package com.sainsburys.converters;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.sainsburys.model.PageData;
import com.sainsburys.model.ViewModel;
import com.sainsburys.model.product.PageProduct;
import com.sainsburys.model.product.ProductPageData;
import com.sainsburys.model.product.ProductViewContainer;
import com.sainsburys.model.product.ProductViewModel;
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
			viewProduct.setUnitPrice(pageProduct.getUnitPrice().setScale(2, RoundingMode.HALF_EVEN));
			viewProduct.setSize(new BigDecimal(pageProduct.getSize()).divide(new BigDecimal(1024)).setScale(2,RoundingMode.HALF_EVEN) + "kb");
			
			viewProductList.add(viewProduct);
			total= total.add(pageProduct.getUnitPrice());
			
			
		}
		container.setResults(viewProductList);
		container.setTotal(total.setScale(2,RoundingMode.HALF_EVEN));
		
		return container;
	}

	


}
