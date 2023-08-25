package com.pcp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCatalogItem {

	private String profileName;
	private String entitlement;
	private String entiFunctionData;
}
