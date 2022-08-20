package com.example.boardGamesDatabase.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Document("boardgames")
public class BoardGame {
    @Id
    private Integer id;
    @Field
    private Boolean favourite = false;
    @Field
    private Boolean own = false;
    @Field
    private Integer totalRating = 0;
    @Field
    private Integer numRating = 0;
    @Field
    private String memo = "";
}
