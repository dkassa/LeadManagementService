package com.LeadManagementService.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LeadManagementService.Dto.AddressDTO;
import com.LeadManagementService.Dto.CustomFieldsDTO;
import com.LeadManagementService.Dto.CustomerDTO;
import com.LeadManagementService.Dto.LeadResponseDto;
import com.LeadManagementService.Model.Lead;
import com.LeadManagementService.Service.LeadManagementService.LeadMangagementService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/leads")
public class LeadController {
	
	
		
		@Autowired
		LeadMangagementService leadmanagementService;
		
		@PostMapping("/create")
		public ResponseEntity<LeadResponseDto> createNewLead(@RequestBody Lead lead){
			
			
			 leadmanagementService.createLead(lead);
			 LeadResponseDto dto=lead.leadto();
			 
			 return new ResponseEntity<>(dto,HttpStatus.OK);
			
			 
			
			
			
			
		}
		
		@PutMapping("/convert/{leadId}")
		@CircuitBreaker(name="Lead",fallbackMethod="fallBack")
		public ResponseEntity<CustomerDTO> updateLead(@PathVariable String leadId, @RequestBody CustomerDTO customerdto){
			
			
			
			return new ResponseEntity<>(leadmanagementService.convertLead(leadId, customerdto),HttpStatus.OK);
		}
		
		public ResponseEntity<?> fallBack(Exception e){
			
			return new ResponseEntity<>("try again later",HttpStatus.OK);
		}

	}



