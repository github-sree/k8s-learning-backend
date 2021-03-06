package com.k8slearning.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
import com.k8slearning.api.PrivilegeApi;
import com.k8slearning.model.Privilege;
import com.k8slearning.service.PrivilegeService;
import com.k8slearning.utils.K8sUtils;

@RestController
@RequestMapping("/v1")
public class PrivileageController {

	@Autowired
	PrivilegeService privilegeService;

	@Autowired
	K8sUtils utils;

	@PostMapping("/privilege")
	public ResponseEntity<PrivilegeApi> createPrivileges(@RequestBody PrivilegeApi privilegeApi) {
		return new ResponseEntity<>(privilegeService.createPrivileges(privilegeApi), HttpStatus.OK);
	}

	@GetMapping("/privilege")
	public ResponseEntity<PagingResponseApi<PrivilegeApi>> retrievePrivileges(final Pageable pageable) {
		Page<Privilege> privilage = privilegeService.retrievePrivileges(pageable);
		PagingResponseApi<PrivilegeApi> contents = new PagingResponseApi<>();
		contents.setTotalCount(privilage.getTotalElements());
		contents.setPageNo(privilage.getNumber());
		contents.setTotalPages(privilage.getTotalPages());
		contents.setPageSize(privilage.getNumberOfElements());
		contents.setRows(utils.mapStream(privilage.get(), PrivilegeApi.class));
		return new ResponseEntity<>(contents, HttpStatus.OK);
	}

	@PutMapping("/privilege/{privilegeId}")
	public ResponseEntity<PrivilegeApi> updatePrivilege(@PathVariable("privilegeId") String privilegeId,
			PrivilegeApi privilegeApi) {
		return new ResponseEntity<>(privilegeService.updatePrivilege(privilegeId, privilegeApi), HttpStatus.OK);
	}

}
