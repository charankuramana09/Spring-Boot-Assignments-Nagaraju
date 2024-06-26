package com.config.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class EmployeeCode {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long empId;
	private String firstName;
	private String lastName;
	@Column(unique = true,nullable = false)
	private String email;
	@Column(nullable = false)
	private String departmentCode;
}
