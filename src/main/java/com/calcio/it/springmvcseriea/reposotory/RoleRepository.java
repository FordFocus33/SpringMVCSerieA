package com.calcio.it.springmvcseriea.reposotory;

import com.calcio.it.springmvcseriea.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
