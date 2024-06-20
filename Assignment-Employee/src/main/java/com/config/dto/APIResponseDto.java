package com.config.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDto {

	private EmployeeCodeDto employeeCode;
	private  DepartmentCodeDto departmentCode;
}
