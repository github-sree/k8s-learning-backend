package com.k8slearning.service.impl.v1;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.k8slearning.api.RoleApi;
import com.k8slearning.model.Privilege;
import com.k8slearning.model.Role;
import com.k8slearning.repository.PrivilegeRepository;
import com.k8slearning.repository.RoleRepository;
import com.k8slearning.service.RoleService;
import com.k8slearning.utils.ConstantsUtil;

@Service
public class RoleServiceImpl implements RoleService {
	private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PrivilegeRepository privilegeRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RoleApi roleResponse;

	@Override
	public RoleApi createRole(RoleApi roleApi) {
		roleResponse.clear();
		try {
			Role roles = modelMapper.map(roleApi, Role.class);
			roles.setRoleId(UUID.randomUUID().toString());
			if (!firstRoleCreated()) {
				roles.setInitialRole(true);
				if (roleApi.getPrivilegeNames() == null) {
					roleApi.setPrivilegeNames(new HashSet<>());
				}
				privilegeRepository.findAll().forEach(privil -> roleApi.getPrivilegeNames().add(privil.getName()));
				roles.setPrivileges(processPrivilege(roleApi.getPrivilegeNames()));
			} else {
				roles.setPrivileges(processPrivilege(roleApi.getPrivilegeNames()));
			}
			roleRepository.save(roles);
			roleResponse = modelMapper.map(roles, RoleApi.class);
			roleResponse.setMessage(ConstantsUtil.ResponseStatus.ROLE_SAVED);
			roleResponse.setStatus(ConstantsUtil.Status.SUCCESS);
		} catch (Exception e) {
			LOGGER.info("exception roles save {}", e.getLocalizedMessage());
		}
		return roleResponse;
	}

	private Set<Privilege> processPrivilege(Set<String> privilegeNames) {
		Set<Privilege> privilegeSets = new HashSet<>();
		Optional.ofNullable(privilegeNames).ifPresent(
				pvSets -> pvSets.forEach(pn -> privilegeSets.add(privilegeRepository.findPrivilegeByName(pn))));
		return privilegeSets;
	}

	@Override
	public Page<Role> retrieveRoles(Pageable pageable) {
		return roleRepository.findAll(pageable);
	}

	@Override
	public RoleApi updateRole(String roleId, RoleApi roleApi) {
		Optional<Role> roleOp = roleRepository.findById(roleId);
		roleOp.ifPresent(role -> {
			role.setPrivileges(null);
			role.setPrivileges(processPrivilege(roleApi.getPrivilegeNames()));
			roleRepository.save(role);
			modelMapper.map(roleApi, role);
			LOGGER.info("updated role details {}", role);
		});
		return null;
	}

	@Override
	public boolean firstRoleCreated() {
		return roleRepository.initialRoleExists();
	}

}
