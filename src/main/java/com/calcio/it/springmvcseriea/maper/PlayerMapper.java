package com.calcio.it.springmvcseriea.maper;

import com.calcio.it.springmvcseriea.dto.PlayerDto;
import com.calcio.it.springmvcseriea.entity.Player;

public class PlayerMapper {

    public static Player mapToPlayer(PlayerDto playerDto){
        return Player.builder()
                .id(playerDto.getId())
                .name(playerDto.getName())
                .type(playerDto.getType())
                .photoUrl(playerDto.getPhotoUrl())
                .updatedOn(playerDto.getUpdatedOn())
                .club(playerDto.getClub())
                .build();
    }

    public static PlayerDto mapToPlayerDto(Player player){
        return PlayerDto.builder()
                .id(player.getId())
                .name(player.getName())
                .type(player.getType())
                .photoUrl(player.getPhotoUrl())
                .updatedOn(player.getUpdatedOn())
                .club(player.getClub())
                .build();
    }
}
