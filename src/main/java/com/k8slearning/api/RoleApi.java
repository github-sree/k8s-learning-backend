package com.k8slearning.api;

import java.util.Set;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(value = Include.NON_NULL)
public class RoleApi extends ResponseApi {
	private String roleId;
	@NotNull(message = "role name is required")
	private String roleName;
	private boolean active = true;
	private Set<String> privilegeNames;
	private Set<PrivilegeApi> privileges;

}
