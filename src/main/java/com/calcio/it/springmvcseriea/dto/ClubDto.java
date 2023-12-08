package com.calcio.it.springmvcseriea.dto;

import com.calcio.it.springmvcseriea.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClubDto {
    private Long id;
    private String title;
    private String photoUrl;
    private String content;

    private UserEntity createdBy;
    private List<PlayerDto> players = new ArrayList<>();

}
