package com.sainsburys.scraper;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sainsburys.model.PageData;
import com.sainsburys.model.product.PageProduct;
import com.sainsburys.model.product.ProductPageData;
@Component
public class ProductPageScraper implements PageScraper{

	@Autowired
	private HTTPInfoHelper httpInfoHelper;
	
	public void setHttpInfoHelper(HTTPInfoHelper httpInfoHelper) {
		this.httpInfoHelper = httpInfoHelper;
	}



	@Override
	public PageData scrapePage(String url) {

		Document document = this.getHTMLDocument(url);
		
		
		Elements product = document.getElementsByClass("product");
		
		ProductPageData pageData = new ProductPageData();
		ArrayList<PageProduct> productList = new ArrayList<PageProduct>(product.size());
		for(Element row:product){
			PageProduct pageProduct = new PageProduct();
			pageProduct.setTitle(row.select("a").first().text());
			
			String link =row.select("a").attr("href");
			
			
			pageProduct.setDescription(getHTMLDocument(link).getElementsByAttributeValue("name","description").attr("content"));
			pageProduct.setSize(httpInfoHelper.getLinkedDocumentSize(link));
			pageProduct.setUnitPrice(new BigDecimal(row.getElementsByClass("pricePerUnit").text().replaceAll("\\D","")).divide(new BigDecimal(100)));
			productList.add(pageProduct);
		}
		pageData.setProducts(productList);
		
		return pageData;
	}

	

	 /**
	  * get the HTML document from the url
	  * @param url
	  * @return
	  */
	protected Document getHTMLDocument(String url) {
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			
			throw new RuntimeException("Error getting the HTML Document", e);
		}
		
		return doc;
	}
	


	

	

}
