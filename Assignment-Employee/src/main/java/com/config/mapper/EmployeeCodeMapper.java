package com.config.mapper;

import com.config.dto.EmployeeCodeDto;
import com.config.entity.EmployeeCode;

public class EmployeeCodeMapper {
	
	public static EmployeeCodeDto mapToEmployeCodeDto(EmployeeCode employeeCode) {
		
		//convert DepartmentCode Jpa Entity into DepartmentCodeDto
		EmployeeCodeDto employeeCodeDto=new EmployeeCodeDto(
				employeeCode.getEmpId(),
				employeeCode.getFirstName(),
				employeeCode.getLastName(),
				employeeCode.getEmail(),
				employeeCode.getDepartmentCode()
				
				);
		return employeeCodeDto;
	}
	
	public static EmployeeCode mapToEmployeeCode(EmployeeCodeDto employeeCodeDto) {
		//convert DepartmentCodeDto into DepartmentCode Jpa Entity
		EmployeeCode employeeCode=new EmployeeCode(
				employeeCodeDto.getEmpId(),
				employeeCodeDto.getFirstName(),
				employeeCodeDto.getLastName(),
				employeeCodeDto.getEmail(),
				employeeCodeDto.getDepartmentCode()
				);
		return employeeCode;
	}

}
