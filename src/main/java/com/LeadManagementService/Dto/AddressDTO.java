package com.LeadManagementService.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AddressDTO {
	private String street;
	private String city;
	private String state;
	private String zipcode;

}
