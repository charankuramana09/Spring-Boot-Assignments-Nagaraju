package com.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.config.entity.DepartmentCode;


@Repository
public interface DepartmentCodeRepo extends JpaRepository<DepartmentCode, Long>{
	DepartmentCode findByDepartmentCode(String departmentCode);
}
