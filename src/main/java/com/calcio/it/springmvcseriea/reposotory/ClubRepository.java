package com.calcio.it.springmvcseriea.reposotory;

import com.calcio.it.springmvcseriea.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {
}
