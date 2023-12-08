package com.calcio.it.springmvcseriea.service;

import com.calcio.it.springmvcseriea.dto.ClubDto;
import com.calcio.it.springmvcseriea.entity.Club;

import java.util.List;

public interface ClubService {

    List<ClubDto> findAllClubs();
    Club saveClub(ClubDto clubDto);
    ClubDto findClubById(Long id);
    void updateClub(ClubDto clubDto);
    void deleteClub(Long id);
    List<ClubDto> searchClubs(String query);
}
