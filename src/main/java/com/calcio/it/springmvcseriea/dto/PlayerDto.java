package com.calcio.it.springmvcseriea.dto;

import com.calcio.it.springmvcseriea.entity.Club;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {
    private Long id;
    @NotEmpty(message = "The name must be not empty")
    private String name;
    @NotEmpty(message = "The type must be not empty")
    private String type;
    @NotEmpty(message = "The url must be not empty")
    private String photoUrl;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private Club club;
}
