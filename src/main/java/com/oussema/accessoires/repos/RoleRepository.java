package com.oussema.accessoires.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.oussema.accessoires.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}
