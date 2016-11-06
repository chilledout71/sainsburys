package com.sainsburys.converters;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.sainsburys.model.PageProduct;
import com.sainsburys.model.ProductPageData;
import com.sainsburys.model.ProductViewContainer;
import com.sainsburys.model.ProductViewModel;
import com.sainsburys.model.ViewModel;

public class ProductConverterTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {

	ProductPageData productPage = new ProductPageData();
	ArrayList<PageProduct> pageList = new ArrayList<PageProduct>(2);
	PageProduct pageProduct1 = new PageProduct();
	pageProduct1.setDescription("description1");
	pageProduct1.setSize(23456);
	pageProduct1.setTitle("title1");
	pageProduct1.setUnitPrice("1.80");
	pageList.add(pageProduct1);
	
	
	PageProduct pageProduct2 = new PageProduct();
	pageProduct2.setDescription("description2");
	pageProduct2.setSize(12347);
	pageProduct2.setTitle("title2");
	pageProduct2.setUnitPrice("2.80");
	pageList.add(pageProduct2);
	productPage.setProducts(pageList);
	
	PageDataConverter converter = new ProductConverter();
	ViewModel viewModel = converter.toViewModel(productPage);
	
	assertTrue(viewModel instanceof ProductViewContainer);
	ProductViewContainer productViewModel = (ProductViewContainer)viewModel;
	assertEquals("description1", productViewModel.getResults().get(0).getDescription());
	assertEquals("title1", productViewModel.getResults().get(0).getTitle());
	assertEquals(new BigDecimal(1.80).setScale(2,RoundingMode.HALF_EVEN), productViewModel.getResults().get(0).getUnitPrice());
	assertEquals("22.91kb", productViewModel.getResults().get(0).getSize());

	
	assertEquals(new BigDecimal(2.8).setScale(2, RoundingMode.HALF_EVEN), productViewModel.getResults().get(1).getUnitPrice());
	assertEquals("title2", productViewModel.getResults().get(1).getTitle());
	assertEquals("description2", productViewModel.getResults().get(1).getDescription());
	assertEquals(new BigDecimal(2.80).setScale(2,RoundingMode.HALF_EVEN), productViewModel.getResults().get(1).getUnitPrice());
	assertEquals("12.06kb", productViewModel.getResults().get(1).getSize());
	assertEquals(new BigDecimal(4.60).setScale(2,RoundingMode.HALF_EVEN), productViewModel.getTotal());
	
	
	}

}
