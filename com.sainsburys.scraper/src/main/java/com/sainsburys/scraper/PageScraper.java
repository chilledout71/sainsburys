package com.sainsburys.scraper;

import com.sainsburys.model.PageData;
/**
 * Object to scrape HTML from a website
 * @author leeharris
 *
 */
public interface PageScraper {
/**
 * scrape the page from the url provided and 
 * return a data object that contains the required data
 * @param url
 * @return
 */
	PageData scrapePage(String url);
	
	
}
