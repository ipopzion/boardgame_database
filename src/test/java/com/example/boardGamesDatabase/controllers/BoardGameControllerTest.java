package com.example.boardGamesDatabase.controllers;

import com.example.boardGamesDatabase.entities.BoardGame;
import com.example.boardGamesDatabase.services.BoardGameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static com.example.boardGamesDatabase.constants.MockConstants.mockId1;
import static com.example.boardGamesDatabase.factories.BoardGameFactory.generateBoardGame1;
import static com.example.boardGamesDatabase.factories.BoardGameFactory.generateBoardGameList1;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class BoardGameControllerTest {
    @Mock
    private BoardGameService boardGameService;

    @InjectMocks
    private BoardGameController boardGameController;

    @Test
    public void returnBG_whenBGIsCreated() {
        Mockito.when(boardGameService.create(any(BoardGame.class))).thenReturn(generateBoardGame1());
        BoardGame outputGame = boardGameController.create(generateBoardGame1());
        assertEquals(generateBoardGame1(), outputGame);
    }

    @Test
    public void returnTrue_whenBGInDB() {
        Mockito.when(boardGameService.existsById(anyInt())).thenReturn(true);
        assertEquals(true, boardGameController.existsById(mockId1));
    }

    @Test
    public void returnFalse_whenBGNotInDB() {
        Mockito.when(boardGameService.existsById(anyInt())).thenReturn(false);
        assertEquals(false, boardGameController.existsById(mockId1));
    }

    @Test
    public void returnBG_whenBGInDB() {
        Mockito.when(boardGameService.readById(anyInt())).thenReturn(generateBoardGame1());
        BoardGame outputGame = boardGameController.readById(mockId1);
        assertEquals(generateBoardGame1(), outputGame);
    }

    @Test
    public void returnListOfBG_whenAtLeastOneBGinDB() {
        Mockito.when(boardGameService.readAll()).thenReturn(generateBoardGameList1());
        List<BoardGame> outputList = boardGameController.readAll();
        assertNotNull(outputList);
        assertEquals(generateBoardGameList1(), outputList);
        assertEquals(generateBoardGameList1().size(), outputList.size());
        assertEquals(generateBoardGameList1().get(0), outputList.get(0));
    }
}
