package com.LeadManagementService.Service;

import com.LeadManagementService.Dto.AddressDTO;

import com.LeadManagementService.Dto.CustomFieldsDTO;
import com.LeadManagementService.Dto.CustomerDTO;
import com.LeadManagementService.Model.Lead;

public interface LeadManagementService {
	
	public interface LeadMangagementService {
		Lead createLead(Lead lead);
		CustomerDTO convertLead(String leadId, CustomerDTO customer1);
		void deleteLead(String leadId);

	}


}
