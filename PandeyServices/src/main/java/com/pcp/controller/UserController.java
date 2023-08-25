package com.pcp.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pcp.model.UserCatalogItem;

@RestController
public class UserController {

	@GetMapping("/home")
	public String index()
	{
		return "Welcome to Auth2";
	}
	
	@GetMapping("/{userId}")
	public List<UserCatalogItem> getCatalog(@PathVariable("userId") String userId)
	{
		return Collections.singletonList(new UserCatalogItem("TL","Rpt_Custody","Pcp_Access"));
	}
	
}
