package com.config.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.config.dto.APIResponseDto;
import com.config.dto.DepartmentCodeDto;
import com.config.dto.EmployeeCodeDto;
import com.config.entity.EmployeeCode;
import com.config.mapper.EmployeeCodeMapper;
import com.config.repository.EmployeeCodeRepo;
import com.config.service.EmployeeCodeService;

@Service
public class EmployeeCodeServiceImpl implements EmployeeCodeService{

	@Autowired
	private EmployeeCodeRepo employeeCodeRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public EmployeeCodeDto createEmployee(EmployeeCodeDto empCodeDto) {
		
		  EmployeeCode employeeCode = EmployeeCodeMapper.mapToEmployeeCode(empCodeDto);
		  EmployeeCode  savedEmployee = employeeCodeRepo.save(employeeCode);
	        return EmployeeCodeMapper.mapToEmployeCodeDto(savedEmployee);
	}

	@Override
	public APIResponseDto getEmployeeById(Long empId) {
		EmployeeCode employeeCode = employeeCodeRepo.findById(empId).get();
//	        return employeeCode.map(EmployeeCodeMapper::mapToEmployeCodeDto).orElse(null);
		ResponseEntity<DepartmentCodeDto> responseEntity = restTemplate.getForEntity("http://localhost:3333/api/departments/code/"+employeeCode.getDepartmentCode(), DepartmentCodeDto.class);

      DepartmentCodeDto departmentCodeDto = responseEntity.getBody();
      EmployeeCodeDto employeeCodeDto=EmployeeCodeMapper.mapToEmployeCodeDto(employeeCode);
      
      APIResponseDto apiResponseDto=new APIResponseDto();
      apiResponseDto.setEmployeeCode(employeeCodeDto);
      apiResponseDto.setDepartmentCode(departmentCodeDto);
      
      return apiResponseDto;
	}

	//Get all details
	@Override
	public List<EmployeeCodeDto> getAllEmployees() {
		 List<EmployeeCode> employeeCodes = employeeCodeRepo.findAll();
	        return employeeCodes.stream()
	                .map(EmployeeCodeMapper::mapToEmployeCodeDto)
	                .collect(Collectors.toList());
	}

	//Get All Details (Employee + Department) By using restTemplate 
	

//	@Override
//	public List<EmployeeCodeDto> getAllEmployees() {
//	    // Fetch all employees
//	    List<EmployeeCode> employeeCodes = employeeCodeRepo.findAll();
//	    
//	    // Fetch all departments from the department service
//	    ResponseEntity<DepartmentCodeDto[]> responseEntity = restTemplate.getForEntity(
//	        "http://localhost:3333/api/departments", DepartmentCodeDto[].class
//	    );
//	    DepartmentCodeDto[] departmentCodeArray = responseEntity.getBody();
//	    List<DepartmentCodeDto> departmentCodeDtos = Arrays.asList(departmentCodeArray);
//
//	    // Map department codes to a dictionary for easy lookup
//	    Map<String, DepartmentCodeDto> departmentCodeMap = departmentCodeDtos.stream()
//	        .collect(Collectors.toMap(DepartmentCodeDto::getDepartmentCode, dept -> dept));
//
//	    // Map employees and set their corresponding department details
//	    return employeeCodes.stream()
//	        .map(employee -> {
//	            EmployeeCodeDto employeeCodeDto = EmployeeCodeMapper.mapToEmployeCodeDto(employee);
//	            DepartmentCodeDto departmentCodeDto = departmentCodeMap.get(employee.getDepartmentCode());
//	            if (departmentCodeDto != null) {
//	                employeeCodeDto.setDepartmentCode(departmentCodeDto);
//	            }
//	            return employeeCodeDto;
//	        })
//	        .collect(Collectors.toList());
//	}

	
	
	@Override
	public EmployeeCodeDto updateEmployee(Long empId, EmployeeCodeDto empCodeDto) {
		Optional<EmployeeCode> optionalEmployee = employeeCodeRepo.findById(empId);
        if (optionalEmployee.isPresent()) {
        	EmployeeCode employeeCode = optionalEmployee.get();
        	employeeCode.setFirstName(empCodeDto.getFirstName());
        	employeeCode.setLastName(empCodeDto.getLastName());
        	employeeCode.setEmail(empCodeDto.getEmail());

        	EmployeeCode updatedEmployee = employeeCodeRepo.save(employeeCode);
            return EmployeeCodeMapper.mapToEmployeCodeDto(updatedEmployee);
        }
        return null;
	}

	@Override
	public void deleteEmployee(Long empId) {
		 if (employeeCodeRepo.existsById(empId)) {
			 employeeCodeRepo.deleteById(empId);
	        }
		
	}

	

}
