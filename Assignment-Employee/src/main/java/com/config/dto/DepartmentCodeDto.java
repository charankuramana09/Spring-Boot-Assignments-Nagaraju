package com.config.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class DepartmentCodeDto {
	
	 private Long deptId;
	    private String deptName;
	    private LocalDateTime createdDateTime;	  
	    private String createdByUsername;
	    private LocalDateTime updatedDateTime;
	    private String updatedByUser;
	    private String departmentCode;
}
