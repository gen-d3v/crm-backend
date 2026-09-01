package com.crmnexus.backend.repository;

import com.crmnexus.backend.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
UserEntity findByEmailOrUsername(String email, String username);
boolean existsUserEntitiesByEmail(String email);
boolean existsUserEntitiesByUsername(String username);
}
