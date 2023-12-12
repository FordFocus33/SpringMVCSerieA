package com.calcio.it.springmvcseriea.service;

import com.calcio.it.springmvcseriea.dto.PlayerDto;

import java.util.List;

public interface PlayerService {
    void createPlayer(Long clubId, PlayerDto playerDto);

    List<PlayerDto> findAllPlayers();

    PlayerDto findById(Long id);

    void updatePlayer(Long id, PlayerDto playerDto);

    void deletePlayer(Long id);
}
