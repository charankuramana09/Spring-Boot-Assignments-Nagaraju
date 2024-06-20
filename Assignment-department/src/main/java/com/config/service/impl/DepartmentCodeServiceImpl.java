package com.config.service.impl;

import com.config.dto.APIResponseDto;
import com.config.dto.DepartmentCodeDto;
import com.config.dto.EmployeeCodeDto;
import com.config.entity.DepartmentCode;
import com.config.mapper.DepartmentCodeMapper;
import com.config.repository.DepartmentCodeRepo;
import com.config.service.DepartmentCodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentCodeServiceImpl implements DepartmentCodeService {

    @Autowired
    private DepartmentCodeRepo departmentCodeRepo;
    
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public DepartmentCodeDto createDepartment(DepartmentCodeDto deptCodeDto) {
        DepartmentCode departmentCode = DepartmentCodeMapper.mapToDepartmentCode(deptCodeDto);
        departmentCode.setCreatedDateTime(LocalDateTime.now());
        departmentCode.setUpdatedDateTime(LocalDateTime.now());
        
        DepartmentCode savedDepartment = departmentCodeRepo.save(departmentCode);
        return DepartmentCodeMapper.mapToDepartmentCodeDto(savedDepartment);
    }

    @Override
    public DepartmentCodeDto getDepartmentById(Long deptId) {
        Optional<DepartmentCode> departmentCode = departmentCodeRepo.findById(deptId);
        return departmentCode.map(DepartmentCodeMapper::mapToDepartmentCodeDto).orElse(null);
    }

    @Override
    public List<DepartmentCodeDto> getAllDepartments() {
        List<DepartmentCode> departmentCodes = departmentCodeRepo.findAll();
        return departmentCodes.stream()
                .map(DepartmentCodeMapper::mapToDepartmentCodeDto)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentCodeDto updateDepartment(Long deptId, DepartmentCodeDto deptCodeDto) {
        Optional<DepartmentCode> optionalDepartment = departmentCodeRepo.findById(deptId);
        if (optionalDepartment.isPresent()) {
            DepartmentCode departmentCode = optionalDepartment.get();
            departmentCode.setDeptName(deptCodeDto.getDeptName());
            departmentCode.setDepartmentCode(deptCodeDto.getDepartmentCode());
            departmentCode.setUpdatedDateTime(LocalDateTime.now());

            DepartmentCode updatedDepartment = departmentCodeRepo.save(departmentCode);
            return DepartmentCodeMapper.mapToDepartmentCodeDto(updatedDepartment);
        }
        return null;
    }

    @Override
    public void deleteDepartment(Long deptId) {
        if (departmentCodeRepo.existsById(deptId)) {
            departmentCodeRepo.deleteById(deptId);
        }
    }

    //Get Employee details by using department code 
//	@Override
//	public DepartmentCodeDto getDepartmentByCode(String departmentCode) {
//		 DepartmentCode department = departmentCodeRepo.findByDepartmentCode(departmentCode);
//	        DepartmentCodeDto departmentCodeDto = DepartmentCodeMapper.mapToDepartmentCodeDto(department);
//	        return departmentCodeDto;
//	}
    
    @Override
	public  APIResponseDto getDepartmentByCode(String departmentCode) {
		 DepartmentCode department = departmentCodeRepo.findByDepartmentCode(departmentCode);
		ResponseEntity<EmployeeCodeDto> responseEntity=  restTemplate.getForEntity("http://localhost:4444/api/employees/"+department.getDepartmentCode(), EmployeeCodeDto.class);
		  
		EmployeeCodeDto employeeCodeDto = responseEntity.getBody();
	      DepartmentCodeDto departmentCodeDto=DepartmentCodeMapper.mapToDepartmentCodeDto(department);
	      
	      APIResponseDto apiResponseDto=new APIResponseDto();
	      apiResponseDto.setEmployeeCode(employeeCodeDto);
	      apiResponseDto.setDepartmentCode(departmentCodeDto);
	      
	      return apiResponseDto;
	}
}
