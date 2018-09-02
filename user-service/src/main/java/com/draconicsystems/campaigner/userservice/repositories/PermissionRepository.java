package com.draconicsystems.campaigner.userservice.repositories;

import com.draconicsystems.campaigner.userservice.domain.Permission;
import org.springframework.data.repository.CrudRepository;

public interface PermissionRepository extends CrudRepository<Permission, Long> {
}
