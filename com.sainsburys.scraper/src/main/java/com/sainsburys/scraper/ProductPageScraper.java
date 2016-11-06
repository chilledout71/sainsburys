package com.sainsburys.scraper;

import org.springframework.stereotype.Component;

import com.sainsburys.model.PageData;
@Component
public class ProductPageScraper extends AbstractPageScraper {

	@Override
	public PageData scrapePage(String url) {

		super.getHTMLDocument(url);
		
		return null;
	}

	

}
