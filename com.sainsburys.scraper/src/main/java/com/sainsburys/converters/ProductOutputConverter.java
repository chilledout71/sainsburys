package com.sainsburys.converters;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sainsburys.model.ViewModel;
@Component
public class ProductOutputConverter implements OutputConverter {

	@Override
	public String toJson(ViewModel viewModel) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonOutput= new String();
		try {
			jsonOutput = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(viewModel);
		} catch (JsonProcessingException e) {
			
			throw new RuntimeException("Error writing JSON output", e);
		}
		
		return jsonOutput;
	}


}
