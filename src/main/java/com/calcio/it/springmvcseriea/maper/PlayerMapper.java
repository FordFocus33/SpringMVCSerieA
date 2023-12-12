package com.calcio.it.springmvcseriea.maper;

import com.calcio.it.springmvcseriea.dto.PlayerDto;
import com.calcio.it.springmvcseriea.entity.Player;

public class PlayerMapper {

    public static Player mapToPlayer(PlayerDto playerDto) {
        return Player.builder()
                .id(playerDto.getId())
                .name(playerDto.getName())
                .type(playerDto.getType())
                .photoUrl(playerDto.getPhotoUrl())
                .createdOn(playerDto.getCreatedOn())
                .updatedOn(playerDto.getUpdatedOn())
                .club(playerDto.getClub())
                .build();
    }

    public static PlayerDto mapToPlayerDto(Player player){
        return PlayerDto.builder()
                .type(player.getType())
                .name(player.getName())
                .photoUrl(player.getPhotoUrl())
                .id(player.getId())
                .createdOn(player.getCreatedOn())
                .updatedOn(player.getUpdatedOn())
                .club(player.getClub())
                .build();
    }
}