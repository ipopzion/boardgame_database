package com.example.boardGamesDatabase.factories;

import com.example.boardGamesDatabase.entities.BoardGame;

import java.util.List;

import static com.example.boardGamesDatabase.constants.MockConstants.*;

public class BoardGameFactory {

    public static BoardGame generateBoardGame0() {
        BoardGame mockBoardGame0 = BoardGame.builder()
                .id(mockId0)
                .build();
        return mockBoardGame0;
    }
    public static BoardGame generateBoardGame1() {
        BoardGame mockBoardGame1 = BoardGame.builder()
                .id(mockId1)
                .favourite(mockFavourite1)
                .own(mockOwn1)
                .totalRating(mockTotalRating1)
                .numRating(mockNumRating1)
                .memo(mockMemo1)
                .build();
        return mockBoardGame1;
    }

    public static BoardGame generateBoardGame2() {
        BoardGame mockBoardGame2 = BoardGame.builder()
                .id(mockId2)
                .favourite(mockFavourite1)
                .own(mockOwn1)
                .totalRating(mockTotalRating2)
                .numRating(mockNumRating2)
                .memo(mockMemo2)
                .build();
        return mockBoardGame2;
    }

    public static List<BoardGame> generateBoardGameList1() {
        List<BoardGame> mockBoardGameList1 = List.of(generateBoardGame0(), generateBoardGame1(), generateBoardGame2());
        return mockBoardGameList1;
    }
}