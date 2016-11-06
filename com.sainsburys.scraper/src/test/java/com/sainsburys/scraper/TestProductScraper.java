/**
 * 
 */
package com.sainsburys.scraper;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.math.BigDecimal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

import com.sainsburys.model.product.ProductPageData;

/**
 * @author leeharris
 *
 */
public class TestProductScraper {

	private ProductPageScraper scraper;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		class FileReadingPageScraper extends ProductPageScraper{	
		@Override
		protected Document getHTMLDocument(String url) {
			
			try {
				return Jsoup.parse(this.getClass().getResourceAsStream(url),
						null, "/");
			} catch (IOException e) {
				
				throw new RuntimeException();
			}
		}
	};
	scraper = new FileReadingPageScraper();
	
	HTTPInfoHelper httpHelper= new HTTPInfoHelper() {
		
		@Override
		public int getLinkedDocumentSize(String link) {
			
			return 2354;
		}
	};
	scraper.setHttpInfoHelper(httpHelper);
	}

	
	/**
	 * Test method for {@link com.sainsburys.scraper.ProductPageScraper#scrapePage(java.lang.String)}.
	 */
	@Test
	public void testScrapePage() {
		
		ProductPageData data = (ProductPageData) scraper.scrapePage("/productPageScraperTest.html");
		
		assertEquals("Sainsbury's Apricot Ripe & Ready x5",data.getProducts().get(0).getTitle());
		assertEquals("Linked Page Description",data.getProducts().get(0).getDescription());
		assertEquals(new BigDecimal(3.50),data.getProducts().get(0).getUnitPrice());
		assertEquals(2354,data.getProducts().get(0).getSize());
		
		
	}

}
