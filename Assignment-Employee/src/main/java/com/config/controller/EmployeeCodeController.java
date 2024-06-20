package com.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.config.dto.APIResponseDto;
import com.config.dto.EmployeeCodeDto;
import com.config.service.EmployeeCodeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeCodeController {

	@Autowired
	private EmployeeCodeService employeeCodeService;
	
    @PostMapping("/save")
	 public ResponseEntity<EmployeeCodeDto> createEmployee(@RequestBody EmployeeCodeDto employeeCodeDto){
		 EmployeeCodeDto createdEmployee=employeeCodeService.createEmployee(employeeCodeDto);
		 return ResponseEntity.ok(createdEmployee);
	 }
    
    
    // Get a department by ID
    @GetMapping("/{id}")
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable("id") Long id) {
    	APIResponseDto apiResponseDto = employeeCodeService.getEmployeeById(id);
        return apiResponseDto != null ? ResponseEntity.ok(apiResponseDto) : ResponseEntity.notFound().build();
    }

    // Get all departments
    @GetMapping
    public ResponseEntity<List<EmployeeCodeDto>> getAllEmployees() {
        List<EmployeeCodeDto> employees =employeeCodeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // Update a department
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeCodeDto> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeCodeDto employeeCodeDto) {
    	EmployeeCodeDto updatedEmployee =employeeCodeService.updateEmployee(id, employeeCodeDto);
        return updatedEmployee != null ? ResponseEntity.ok(updatedEmployee) : ResponseEntity.notFound().build();
    }

    // Delete a department
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable("id") Long id) {
    	employeeCodeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

}
