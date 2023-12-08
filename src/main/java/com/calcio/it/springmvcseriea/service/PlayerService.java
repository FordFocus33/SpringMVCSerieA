package com.calcio.it.springmvcseriea.service;

import com.calcio.it.springmvcseriea.dto.PlayerDto;

import java.util.List;

public interface PlayerService {
    void createPlayer(Long clubId, PlayerDto eventDto);
    List<PlayerDto> findAllPlayers();
    PlayerDto findByPlayerId(Long playerId);
    void updatePlayer(Long id, PlayerDto playerDto);
    void deletePlayer(Long playerId);
}
