package com.sainsburys.scraper;

public interface HTTPInfoHelper {
	
	/**
	 * open the linked page and check the contentLength
	 * @param link
	 * @return
	 */
	public int getLinkedDocumentSize(String link);

}