package com.config.service;

import java.util.List;

import com.config.dto.APIResponseDto;
import com.config.dto.EmployeeCodeDto;


public interface EmployeeCodeService {

	EmployeeCodeDto createEmployee(EmployeeCodeDto empCodeDto);
	
	
  // EmployeeCodeDto getEmployeeById(Long empId);
	   APIResponseDto getEmployeeById(Long empId);

   List<EmployeeCodeDto> getAllEmployees();
   EmployeeCodeDto updateEmployee(Long empId, EmployeeCodeDto empCodeDto);
   void deleteEmployee(Long empId);
}
