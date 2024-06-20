package com.config.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeCodeDto {

	private Long empId;
	private String firstName;
	private String lastName;
	private String email;
	private String departmentCode;

}
