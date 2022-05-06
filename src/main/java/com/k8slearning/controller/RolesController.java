package com.k8slearning.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.k8slearning.api.PagingResponseApi;
import com.k8slearning.api.RoleApi;
import com.k8slearning.model.Role;
import com.k8slearning.service.RoleService;
import com.k8slearning.utils.K8sUtils;

@RestController
@RequestMapping("/v1/auth")
public class RolesController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private K8sUtils utils;

	@PostMapping("/role")
	public ResponseEntity<RoleApi> createRole(@Valid @RequestBody RoleApi roleApi) {
		return new ResponseEntity<>(roleService.createRole(roleApi), HttpStatus.OK);
	}

	@GetMapping("/role")
	public ResponseEntity<PagingResponseApi<RoleApi>> retrieveRoles(final Pageable pageable) {
		Page<Role> pageRole = roleService.retrieveRoles(pageable);
		PagingResponseApi<RoleApi> contents = new PagingResponseApi<>();

		contents.setTotalCount(pageRole.getTotalElements());
		contents.setPageNo(pageRole.getNumber());
		contents.setTotalPages(pageRole.getTotalPages());
		contents.setPageSize(pageRole.getNumberOfElements());
		contents.setRows(utils.mapStream(pageRole.get(), RoleApi.class));
		return new ResponseEntity<>(contents, HttpStatus.OK);
	}

	@PutMapping("/role/{roleId}")
	public ResponseEntity<RoleApi> updateRole(@PathVariable String roleId, @Valid @RequestBody RoleApi roleApi) {
		return new ResponseEntity<>(roleService.updateRole(roleId, roleApi), HttpStatus.OK);
	}

}
