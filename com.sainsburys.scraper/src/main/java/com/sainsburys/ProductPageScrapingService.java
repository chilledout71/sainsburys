package com.sainsburys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sainsburys.converters.OutputConverter;
import com.sainsburys.converters.PageDataConverter;
import com.sainsburys.model.PageData;
import com.sainsburys.model.ViewModel;
import com.sainsburys.scraper.PageScraper;

@Component
public class ProductPageScrapingService implements PageScrapingService{

	@Autowired
	private PageScraper pageScraper;
	@Autowired
	private PageDataConverter pageToViewConverter;
	
	@Autowired
	private OutputConverter outputConverter;
	
	public String scrapePage(String url) {

		PageData pagedata = pageScraper.scrapePage(url);
		ViewModel viewModel = pageToViewConverter.toViewModel(pagedata);
		
		return outputConverter.toJson(viewModel);
	}
	
}
