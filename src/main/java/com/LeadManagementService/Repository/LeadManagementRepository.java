package com.LeadManagementService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LeadManagementService.Model.Lead;

public interface LeadManagementRepository extends JpaRepository<Lead, String>{

}
