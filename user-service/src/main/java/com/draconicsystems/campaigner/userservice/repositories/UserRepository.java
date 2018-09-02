package com.draconicsystems.campaigner.userservice.repositories;

import com.draconicsystems.campaigner.userservice.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, Long> {
}
