package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
@JsonFilter("SomeBeanFilter")
public class SomeBean {
	private String filter1;
//	@JsonIgnore
	private String filter2;
	private String filter3;
	public SomeBean(String filter1, String filter2, String filter3) {
		super();
		this.filter1 = filter1;
		this.filter2 = filter2;
		this.filter3 = filter3;
	}
	public String getFilter1() {
		return filter1;
	}
	public String getFilter2() {
		return filter2;
	}
	public String getFilter3() {
		return filter3;
	}
	@Override
	public String toString() {
		return "someBean [filter1=" + filter1 + ", filter2=" + filter2 + ", filter3=" + filter3 + "]";
	}
	
}
