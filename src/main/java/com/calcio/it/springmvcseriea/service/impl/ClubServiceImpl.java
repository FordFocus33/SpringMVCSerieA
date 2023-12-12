package com.calcio.it.springmvcseriea.service.impl;

import com.calcio.it.springmvcseriea.dto.ClubDto;
import com.calcio.it.springmvcseriea.entity.Club;
import com.calcio.it.springmvcseriea.entity.UserEntity;
import com.calcio.it.springmvcseriea.maper.ClubMapper;
import com.calcio.it.springmvcseriea.reposotory.ClubRepository;
import com.calcio.it.springmvcseriea.reposotory.UserRepository;
import com.calcio.it.springmvcseriea.security.SecurityUtil;
import com.calcio.it.springmvcseriea.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.calcio.it.springmvcseriea.maper.ClubMapper.mapToClub;
import static com.calcio.it.springmvcseriea.maper.ClubMapper.mapToClubDto;

@Service
public class ClubServiceImpl implements ClubService {

    private ClubRepository clubRepository;
    private UserRepository userRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository, UserRepository userRepository) {
        this.clubRepository = clubRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList());
    }


    // Тут у нас изначально должен был приходить username, но в таблице у нас email идет перед username. Поэтому, будем искать по email
    // Так как в SecurityUtil.getSessionUser()
    @Override
    public Club saveClub(ClubDto clubDto) {
        String email = SecurityUtil.getSessionUser();
        UserEntity user = userRepository.findByEmail(email);
        Club club = mapToClub(clubDto);
        club.setCreatedBy(user);
        return clubRepository.save(club);
    }

    @Override
    public ClubDto findClubById(Long id) {
        Club club = clubRepository.findById(id).get();
        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        String email = SecurityUtil.getSessionUser();
        UserEntity user = userRepository.findByEmail(email);
        Club club = mapToClub(clubDto);
        club.setCreatedBy(user);
        clubRepository.save(club);
    }

    @Override
    public void deleteClub(Long id) {
        clubRepository.deleteById(id);
    }

    @Override
    public List<ClubDto> searchClubs(String query) {
        List<ClubDto> clubDtos = new ArrayList<>();
        for (Club club : clubRepository.searchClubs(query)){
            clubDtos.add(mapToClubDto(club));
        }
        return clubDtos;
    }
}