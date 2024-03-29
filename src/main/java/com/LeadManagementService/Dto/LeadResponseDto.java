package com.LeadManagementService.Dto;



import com.LeadManagementService.Model.CustomFields;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeadResponseDto {
	
	private String leadId;
	
	
	private String firstName;
	
	
	private String lastName;
	
	
	private String email;
	
	
	private String phone;
	
	
	private String source;
	

	private String company;
	
	
	private CustomFields customfields;
	
	private String status;
	
	

	
	

}
