/**
 * 
 */
package com.sainsburys.converters;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sainsburys.model.ProductViewContainer;
import com.sainsburys.model.ProductViewModel;
import com.sainsburys.model.ViewModel;

/**
 * @author leeharris
 *
 */
public class TestProductOutputConverter {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.sainsburys.converters.ProductOutputConverter#toJson(com.sainsburys.model.ViewModel)}
	 * .
	 */
	@Test
	public void testToJson() {

		List<ProductViewModel> productViewList = new ArrayList<ProductViewModel>(2);
		ProductViewModel model = new ProductViewModel();
		model.setDescription("this is the description");
		model.setSize("234.6kb");
		model.setTitle("This is the title");
		model.setUnitPrice(new BigDecimal(1.8).setScale(2,
				RoundingMode.HALF_EVEN));

		ProductViewContainer container = new ProductViewContainer();
	
		
		productViewList.add(model);

		ProductViewModel model2 = new ProductViewModel();
		model2.setDescription("this is the description2");
		model2.setSize("123.6kb");
		model2.setTitle("This is the title for model 2");
		model2.setUnitPrice(new BigDecimal(2.8).setScale(2,
				RoundingMode.HALF_EVEN));

		productViewList.add(model2);
		
		container.setTotal(new BigDecimal(4.6).setScale(2,
				RoundingMode.HALF_EVEN));
		
		container.setResults(productViewList);
		ProductOutputConverter converter = new ProductOutputConverter();
		assertEquals(
				"{\n"
				+ "  \"results\" : [ {\n"
				+ "    \"title\" : \"This is the title\",\n"
				+ "    \"size\" : \"234.6kb\",\n"
				+ "    \"unit_price\" : 1.80,\n"
				+ "    \"description\" : \"this is the description\"\n"
				+ "  }, {\n"
				+ "    \"title\" : \"This is the title for model 2\",\n"
				+ "    \"size\" : \"123.6kb\",\n"
				+ "    \"unit_price\" : 2.80,\n"
				+ "    \"description\" : \"this is the description2\"\n"
				+ "  } ],\n"
				+ "  \"total\" : 4.60\n"
				+ "}",
				converter.toJson(container));

	}

}
