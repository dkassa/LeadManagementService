package com.LeadManagementService.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.LeadManagementService.Dto.AddressDTO;
import com.LeadManagementService.Dto.CustomFieldsDTO;
import com.LeadManagementService.Dto.CustomerDTO;
import com.LeadManagementService.Model.Lead;
import com.LeadManagementService.Repository.LeadManagementRepository;
import com.LeadManagementService.Service.LeadManagementService.LeadMangagementService;
import com.fasterxml.jackson.databind.util.JSONPObject;

import lombok.Setter;
import lombok.Getter;

@Service
@ResponseBody
public class LeadManagementServiceImpl implements LeadMangagementService {

	@Autowired
	LeadManagementRepository leadMangagementRepo;

	@Override
	public Lead createLead(Lead lead) {

		return leadMangagementRepo.save(lead);

	}

	@Autowired
	RestTemplate restTemplate;

	@Override
	public CustomerDTO convertLead(String leadId, CustomerDTO customer1) {
		
		//System.out.println("customerDto " + Lead.getCustomfields());
		

		Optional<Lead> optionalCustomer = leadMangagementRepo.findById(leadId);
		if (optionalCustomer.isPresent()) {

			Lead data = optionalCustomer.get();
			
			CustomerDTO customer=new CustomerDTO();
			
			

			customer.setFirstName(data.getFirstName());
			customer.setLastName(data.getLastName());
			customer.setEmail(data.getEmail());
			customer.setPhone(data.getPhone());
			customer.setAddress(customer1.getAddress());
			customer.setCustomfields(customer1.getCustomfields());
			customer.setNotes(customer1.getNotes());
			
			
		


			CustomerDTO dto = restTemplate.postForObject("http://localhost:8080/customers/create", customer,
					CustomerDTO.class);
			
			//leadMangagementRepo.deleteById(leadId);

			return dto;

		}
		return null;
	}

	@Override
	public void deleteLead(String leadId) {
		// TODO Auto-generated method stub
		 leadMangagementRepo.deleteById(leadId);
	}

}

