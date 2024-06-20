package com.config.mapper;

import com.config.dto.DepartmentCodeDto;
import com.config.entity.DepartmentCode;

public class DepartmentCodeMapper {

	public static DepartmentCodeDto mapToDepartmentCodeDto(DepartmentCode departmentCode) {
		
		//convert DepartmentCode Jpa Entity into DepartmentCodeDto
		DepartmentCodeDto departmentCodeDto=new DepartmentCodeDto(
				departmentCode.getDeptId(),
				departmentCode.getDeptName(),
				departmentCode.getCreatedDateTime(),
				departmentCode.getCreatedByUsername(),
				departmentCode.getUpdatedDateTime(),
				departmentCode.getUpdatedByUser(),
				departmentCode.getDepartmentCode(),
				departmentCode.getEmpId()
				);
		return departmentCodeDto;
	}
	
	public static DepartmentCode mapToDepartmentCode(DepartmentCodeDto departmentCodeDto) {
		DepartmentCode departmentCode=new DepartmentCode(
				departmentCodeDto.getDeptId(),
				departmentCodeDto.getDeptName(),
				departmentCodeDto.getCreatedDateTime(),
				departmentCodeDto.getCreatedByUsername(),
				departmentCodeDto.getUpdatedDateTime(),
				departmentCodeDto.getUpdatedByUser(),
				departmentCodeDto.getDepartmentCode(),
				departmentCodeDto.getEmpId()
				);
		return departmentCode;
	}
	
}
