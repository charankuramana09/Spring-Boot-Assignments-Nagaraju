package com.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.config.entity.EmployeeCode;

public interface EmployeeCodeRepo extends JpaRepository<EmployeeCode, Long>{

}
