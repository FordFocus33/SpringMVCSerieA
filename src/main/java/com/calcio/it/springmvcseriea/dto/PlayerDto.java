package com.calcio.it.springmvcseriea.dto;

import com.calcio.it.springmvcseriea.entity.Club;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {
    private Long id;
    private String name;
    private String type;
    private String photoUrl;
    private LocalDateTime updatedOn;

    private Club club;
}