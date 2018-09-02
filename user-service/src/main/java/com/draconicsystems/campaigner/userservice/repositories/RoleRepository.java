package com.draconicsystems.campaigner.userservice.repositories;

import com.draconicsystems.campaigner.userservice.domain.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}
