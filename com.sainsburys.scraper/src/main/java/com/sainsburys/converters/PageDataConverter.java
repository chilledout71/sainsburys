package com.sainsburys.converters;

import com.sainsburys.model.PageData;
import com.sainsburys.model.ViewModel;
/**
 * converts a pageData objects
 * @author leeharris
 *
 */
public interface PageDataConverter {
/**
 * convert a PageData Object to a viewModel
 * @param pageData
 * @return
 */
	ViewModel toViewModel(PageData pageData);
	
}
