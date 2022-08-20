package com.example.boardGamesDatabase.services;

import com.example.boardGamesDatabase.entities.BoardGame;
import com.example.boardGamesDatabase.exceptions.BoardGameNotFoundException;
import com.example.boardGamesDatabase.repositories.BoardGameRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static com.example.boardGamesDatabase.factories.BoardGameFactory.generateBoardGame1;
import static com.example.boardGamesDatabase.factories.BoardGameFactory.generateBoardGameList1;
import static com.example.boardGamesDatabase.constants.MockConstants.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class BoardGameServiceTest {
    @Mock
    private BoardGameRepository boardGameRepository;

    @InjectMocks
    private BoardGameService boardGameService;

    @Test
    public void returnBG_whenBGIsCreated() {
        Mockito.when(boardGameRepository.save(any(BoardGame.class))).thenReturn(generateBoardGame1());
        BoardGame outputGame = boardGameService.create(generateBoardGame1());
        assertEquals(generateBoardGame1(), outputGame);
    }

    @Test
    public void returnTrue_whenBGInDB() {
        Mockito.when(boardGameRepository.existsById(anyInt())).thenReturn(true);
        assertEquals(true, boardGameService.existsById(mockId1));
    }

    @Test
    public void returnFalse_whenBGNotInDB() {
        Mockito.when(boardGameRepository.existsById(anyInt())).thenReturn(false);
        assertEquals(false, boardGameService.existsById(mockId1));
    }

    @Test
    public void returnBG_whenBGInDB() {
        Mockito.when(boardGameRepository.findById(anyInt())).thenReturn(Optional.ofNullable(generateBoardGame1()));
        BoardGame outputGame = boardGameService.readById(mockId1);
        assertEquals(generateBoardGame1(), outputGame);
    }

    @Test
    public void throwBGNotFoundException_whenBGNotInDB() {
        Mockito.when(boardGameRepository.findById(anyInt())).thenReturn(Optional.empty());
        assertThrows(BoardGameNotFoundException.class, () -> boardGameService.readById(mockId1));
    }

    @Test
    public void returnListOfBG_whenAtLeastOneBGinDB() {
        Mockito.when(boardGameRepository.findAll()).thenReturn(generateBoardGameList1());
        List<BoardGame> outputList = boardGameService.readAll();
        assertNotNull(outputList);
        assertEquals(generateBoardGameList1(), outputList);
        assertEquals(generateBoardGameList1().size(), outputList.size());
        assertEquals(generateBoardGameList1().get(0), outputList.get(0));
    }

    @Test
    public void returnBG_whenBGIsUpdated() {
        Mockito.when(boardGameRepository.save(any(BoardGame.class))).thenReturn(generateBoardGame1());
        BoardGame outputGame = boardGameService.update(generateBoardGame1());
        assertEquals(generateBoardGame1(), outputGame);
    }

    @Test
    public void returnBG_whenBGInDBIsDeleted() {
        Mockito.when(boardGameRepository.findById(anyInt())).thenReturn(Optional.ofNullable(generateBoardGame1()));
        BoardGame outputGame = boardGameService.deleteById(mockId1);
        assertEquals(generateBoardGame1(), outputGame);
    }

    @Test
    public void throwBGNotFoundException_whenTryingToDeleteBGInNotDB() {
        Mockito.when(boardGameRepository.findById(anyInt())).thenReturn(Optional.empty());
        assertThrows(BoardGameNotFoundException.class, () -> boardGameService.deleteById(mockId1));
    }
}
