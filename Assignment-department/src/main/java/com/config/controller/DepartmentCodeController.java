package com.config.controller;

import com.config.dto.APIResponseDto;
import com.config.dto.DepartmentCodeDto;
import com.config.service.DepartmentCodeService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentCodeController {

    @Autowired
    private DepartmentCodeService departmentCodeService;

    // Create a new department
    @PostMapping("/save")
    public ResponseEntity<DepartmentCodeDto> createDepartment(@RequestBody DepartmentCodeDto departmentCodeDto) {
        DepartmentCodeDto createdDepartment = departmentCodeService.createDepartment(departmentCodeDto);
        return ResponseEntity.ok(createdDepartment);
    }

    // Get a department by ID
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentCodeDto> getDepartmentById(@PathVariable("id") Long id) {
        DepartmentCodeDto departmentCodeDto = departmentCodeService.getDepartmentById(id);
        return departmentCodeDto != null ? ResponseEntity.ok(departmentCodeDto) : ResponseEntity.notFound().build();
    }

    // Get all departments
    @GetMapping
    public ResponseEntity<List<DepartmentCodeDto>> getAllDepartments() {
        List<DepartmentCodeDto> departments = departmentCodeService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    // Update a department
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentCodeDto> updateDepartment(@PathVariable("id") Long id, @RequestBody DepartmentCodeDto departmentCodeDto) {
        DepartmentCodeDto updatedDepartment = departmentCodeService.updateDepartment(id, departmentCodeDto);
        return updatedDepartment != null ? ResponseEntity.ok(updatedDepartment) : ResponseEntity.notFound().build();
    }

    // Delete a department
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable("id") Long id) {
        departmentCodeService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
    
    //Get department by using department code
    
    // Build get department rest api
    @GetMapping("/code/{departmentCode}")
    public ResponseEntity<APIResponseDto> getDepartment(@PathVariable("departmentCode") String departmentCode){
    	 APIResponseDto departmentCodeDto =departmentCodeService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentCodeDto, HttpStatus.OK);
    }
}
