package com.db.dto;

import com.db.model.Customer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class OrderResponse{
	
	private String name;
	private String productName;
	
	// response class doesn't matches as per the join query in repo
	//we have to exclude the default value from the class
	// so that it doesn't throws exception and gets included in response with '0' value 
	private int price;
}
