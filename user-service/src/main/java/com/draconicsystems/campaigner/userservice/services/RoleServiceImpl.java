package com.draconicsystems.campaigner.userservice.services;

import com.draconicsystems.campaigner.userservice.domain.Role;
import com.draconicsystems.campaigner.userservice.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role createRole(String name) {
        Role role = new Role(name);
        return roleRepository.save(role);
    }

    @Override
    public Role createRole(String name, String description) {
        Role role = new Role(name);
        role.setDescription(description);
        return roleRepository.save(role);
    }

    @Override
    public Role getOrCreateRole(String name) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = createRole(name);
        }
        return role;
    }
}
