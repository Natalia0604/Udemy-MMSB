package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	@Autowired
	private FilteringService FilteringS;
	
	@GetMapping(path="/filtering")
	public SomeBean filtering() {
		return new SomeBean("value1","value2","value3");
	}
	
	@GetMapping(path="/filtering-list")
	public List<SomeBean> filteringList() {
		return Arrays.asList(new SomeBean("va1","va2","va3"),new SomeBean("value4","value5","value6"));
	}
//增加過濾條件--------------------------------------------------------------------------
	//只顯示filter1 & filter3
	@GetMapping(path="/filteringMulityWays")
	public MappingJacksonValue filteringMulityWays() {
		SomeBean someBean =new SomeBean("value1","value2","value3");
		MappingJacksonValue result = FilteringS.filterLogic(someBean,"filter1","filter3");	
		return result;
	}
	
	//只顯示filter1 & filter2
	@GetMapping(path="/filtering-list-MulityWays")
	public MappingJacksonValue filteringListMulityWays() {
		List<SomeBean> list = Arrays.asList(new SomeBean("va1","va2","va3"),new SomeBean("value4","value5","value6"));
		MappingJacksonValue result = FilteringS.filterLogic(list,"filter1","filter2");
		return result;
	}

}
