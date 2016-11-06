package com.sainsburys;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				SpringConfig.class);
		
		
		PageScrapingService pageScraper = (PageScrapingService) context.getBean(PageScrapingService.class);
		System.out.println(pageScraper.scrapePage("http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html"));
		
		context.close();
	}

}
