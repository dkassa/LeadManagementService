package com.LeadManagementService.Model;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.LeadManagementService.Dto.LeadResponseDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "leadTable")

public class Lead {
	@Id
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="demo-lead")
	@GenericGenerator(name="demo-lead",strategy="com.LeadManagementService.Model.StringPrefixSequenceGenerator",parameters= {
			
			@Parameter(name=StringPrefixSequenceGenerator.INCREMENT_PARAM, value="1"),
			@Parameter(name=StringPrefixSequenceGenerator.value_prefix_parameter,value="LEAD"),
			@Parameter(name=StringPrefixSequenceGenerator.number_format_parameter,value="%06d")
			
	})

	private String leadId;

	private String firstName;

	private String lastName;

	private String email;

	private String phone;

	private String source;

	private String company;

	private CustomFields customfields;

	public LeadResponseDto leadto() {

		LeadResponseDto leaddto = new LeadResponseDto();
		leaddto.setLeadId(leadId);
		leaddto.setFirstName(firstName);
		leaddto.setLastName(lastName);
		leaddto.setEmail(email);
		leaddto.setPhone(phone);
		leaddto.setCompany(company);
		leaddto.setSource(source);
		leaddto.setStatus("open");
		leaddto.setCustomfields(customfields);
	
		

		return leaddto;
	}

}
