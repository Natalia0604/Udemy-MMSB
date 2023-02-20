package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@Service
public class FilteringService {
	//建立篩選邏輯
	public MappingJacksonValue filterLogic(Object param,String v1,String v2) {
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(param);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(v1,v2);
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
	
}
