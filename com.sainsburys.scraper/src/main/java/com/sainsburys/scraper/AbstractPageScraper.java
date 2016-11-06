package com.sainsburys.scraper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * page scrapper abstract class
 * @author leeharris
 *
 */
public abstract class AbstractPageScraper implements PageScraper{
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
