package com.draconicsystems.campaigner.userservice.services;

import com.draconicsystems.campaigner.userservice.domain.Role;

public interface RoleService {
    Role createRole(String name);

    Role createRole(String name, String description);

    Role getOrCreateRole(String name);
}
