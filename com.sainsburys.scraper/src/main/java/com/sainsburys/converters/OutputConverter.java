package com.sainsburys.converters;

import com.sainsburys.model.ViewModel;


/**
 * converts a viewModel object to desired output format
 * @author leeharris
 *
 */
public interface OutputConverter {
/**
 * convert the viewModel to a JSON String
 * @param viewModel
 * @return
 */
	String toJson(ViewModel viewModel);
	
}
