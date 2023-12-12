package com.calcio.it.springmvcseriea.service.impl;

import com.calcio.it.springmvcseriea.dto.PlayerDto;
import com.calcio.it.springmvcseriea.entity.Club;
import com.calcio.it.springmvcseriea.entity.Player;
import com.calcio.it.springmvcseriea.maper.PlayerMapper;
import com.calcio.it.springmvcseriea.reposotory.ClubRepository;
import com.calcio.it.springmvcseriea.reposotory.PlayerRepository;
import com.calcio.it.springmvcseriea.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.calcio.it.springmvcseriea.maper.PlayerMapper.mapToPlayer;
import static com.calcio.it.springmvcseriea.maper.PlayerMapper.mapToPlayerDto;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;
    private ClubRepository clubRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, ClubRepository clubRepository) {
        this.playerRepository = playerRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void createPlayer(Long clubId, PlayerDto playerDto) {
        Club club = clubRepository.findById(clubId).get();
        Player player = mapToPlayer(playerDto);
        player.setClub(club);
        playerRepository.save(player);
    }

    @Override
    public List<PlayerDto> findAllPlayers() {
        List<PlayerDto> playerDtos = new ArrayList<>();
        for (Player player : playerRepository.findAll()){
            playerDtos.add(PlayerMapper.mapToPlayerDto(player));
        }

        return playerDtos;
    }

    @Override
    public PlayerDto findById(Long id) {
        Player player = playerRepository.findById(id).get();
        return mapToPlayerDto(player);
    }

    @Override
    public void updatePlayer(Long id, PlayerDto playerDto) {
        Player clubsPlayer = playerRepository.findById(id).get();
        Player player = mapToPlayer(playerDto);
        player.setId(id);
        player.setClub(clubsPlayer.getClub());
        playerRepository.save(player);
    }

    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
