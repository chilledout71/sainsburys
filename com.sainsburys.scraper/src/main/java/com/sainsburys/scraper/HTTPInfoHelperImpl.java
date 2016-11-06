package com.sainsburys.scraper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Component;
@Component
public class HTTPInfoHelperImpl implements HTTPInfoHelper {
	
	/**
	 * open the linked page and check the contentLength
	 * @param link
	 * @return
	 */
	public int getLinkedDocumentSize(String link) {
		URL url;
		try {
			url = new URL(link);
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error opening linked url", e);
		}
		 HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("HEAD");
            conn.getInputStream();
            return conn.getContentLength();
        } catch (IOException e) {
            return -1;
        } finally {
            conn.disconnect();
        }
    }
	

}
