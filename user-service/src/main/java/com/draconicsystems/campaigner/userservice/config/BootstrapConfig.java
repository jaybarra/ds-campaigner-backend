package com.draconicsystems.campaigner.userservice.config;

import com.draconicsystems.campaigner.userservice.domain.Permission;
import com.draconicsystems.campaigner.userservice.domain.Role;
import com.draconicsystems.campaigner.userservice.services.PermissionService;
import com.draconicsystems.campaigner.userservice.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

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
    public void run(String... args) {
        Permission createUser = permissionService.getOrCreatePermission("CREATE_USER");
        Permission deleteUser = permissionService.getOrCreatePermission("DELETE_USER");
        Permission archiveUser = permissionService.getOrCreatePermission("ARCHIVE_USER");
        Permission activateUser = permissionService.getOrCreatePermission("ACTIVATE_USER");

        List<Permission> adminPermissions = Arrays.asList(createUser, deleteUser, archiveUser, activateUser);

        Role admin = roleService.getOrCreateRole("ADMIN");

        Predicate<Permission> hasPermission = p -> adminPermissions.stream().anyMatch(p2 -> p2.getName().equals(p.getName()));

        if (!admin.getPermissions().stream().allMatch(hasPermission)) {
            admin.getPermissions().addAll(adminPermissions);
        }
    }
}
