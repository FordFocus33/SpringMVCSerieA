package com.calcio.it.springmvcseriea.reposotory;

import com.calcio.it.springmvcseriea.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
