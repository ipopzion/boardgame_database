package com.example.boardGamesDatabase.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.json.JsonObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Document(collection = "boardgames")
public class BoardGame {
    @Id
    private Integer id;
    private Boolean favourite = false;
    private Boolean own = false;
    private Integer totalRating = 0;
    private Integer numRating = 0;
    private String memo = "";
}
