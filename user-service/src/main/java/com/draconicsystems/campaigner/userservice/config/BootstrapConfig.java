package com.draconicsystems.campaigner.userservice.config;

import com.draconicsystems.campaigner.userservice.domain.Permission;
import com.draconicsystems.campaigner.userservice.domain.Role;
import com.draconicsystems.campaigner.userservice.services.PermissionService;
import com.draconicsystems.campaigner.userservice.services.RoleService;
import com.draconicsystems.campaigner.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BootstrapConfig implements CommandLineRunner {
    private PermissionService permissionService;
    private RoleService roleService;

    @Autowired
    public BootstrapConfig(PermissionService permissionService, RoleService roleService) {
        this.permissionService = permissionService;
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
        Permission createUser = permissionService.createPermission("CREATE_USER", "Create users");
        Permission deleteUser = permissionService.createPermission("DELETE_USER", "Delete users");
        Permission archiveUser = permissionService.createPermission("ARCHIVE_USER", "Delete users");
        Permission activateUser = permissionService.createPermission("ACTIVATE_USER", "Delete users");

        Role admin = roleService.getOrCreateRole("ADMIN");
        admin.getPermissions().addAll(Arrays.asList(createUser, deleteUser, archiveUser, activateUser));
    }
}
