package com.draconicsystems.campaigner.userservice.services;

import com.draconicsystems.campaigner.userservice.domain.Permission;

public interface PermissionService {
    Permission createPermission(String name, String description);
}
