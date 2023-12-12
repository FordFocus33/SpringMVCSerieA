package com.calcio.it.springmvcseriea.reposotory;

import com.calcio.it.springmvcseriea.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
