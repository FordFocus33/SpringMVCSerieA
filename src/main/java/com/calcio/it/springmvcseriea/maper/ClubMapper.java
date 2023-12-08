package com.calcio.it.springmvcseriea.maper;

import com.calcio.it.springmvcseriea.dto.ClubDto;
import com.calcio.it.springmvcseriea.entity.Club;

import java.util.stream.Collectors;

public class ClubMapper {


    public static Club mapToClub(ClubDto clubDto){
        Club club = Club.builder()
                .id(clubDto.getId())
                .title(clubDto.getTitle())
                .photoUrl(clubDto.getPhotoUrl())
                .content(clubDto.getContent())
//                .createdBy(clubDto.getCreatedBy())
                .build();

        return club;
    }

    public static ClubDto mapToClubDto(Club club) {
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
//                .createdBy(club.getCreatedBy())
                .players(club.getPlayers().stream().map(PlayerMapper::mapToPlayerDto).collect(Collectors.toList()))
                .build();

        return clubDto;
    }
}
