package com.k8slearning.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "k8_privilege")
public class Privilege {
	@Id
	private String privilegeId;
	@Column(name = "privilege_name", unique = true, nullable = false)
	private String name;
	@Column(name = "privilege_code")
	private Integer code;
}
