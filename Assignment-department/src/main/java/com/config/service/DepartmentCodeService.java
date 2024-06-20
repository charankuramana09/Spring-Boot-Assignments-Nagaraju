package com.config.service;

import java.util.List;

import com.config.dto.APIResponseDto;
import com.config.dto.DepartmentCodeDto;
import com.config.entity.DepartmentCode;


public interface DepartmentCodeService {

	DepartmentCodeDto createDepartment(DepartmentCodeDto deptCodeDto);
	
	 // Read operation
    DepartmentCodeDto getDepartmentById(Long deptId);
    List<DepartmentCodeDto> getAllDepartments();

    // Update operation
    DepartmentCodeDto updateDepartment(Long deptId, DepartmentCodeDto deptCodeDto);

    // Delete operation
    void deleteDepartment(Long deptId);
    
    //get department by using department code
//    DepartmentCodeDto getDepartmentByCode(String departmentCode);
    
    
    APIResponseDto getDepartmentByCode(String departmentCode);
}
