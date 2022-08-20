package com.example.boardGamesDatabase.services;

import com.example.boardGamesDatabase.entities.BoardGame;
import com.example.boardGamesDatabase.exceptions.BoardGameNotFoundException;
import com.example.boardGamesDatabase.repositories.BoardGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardGameService {
    @Autowired
    private BoardGameRepository boardGameRepository;

    public BoardGame create(BoardGame boardGame) {
        return boardGameRepository.save(boardGame);
    }

    public boolean existsById(Integer id) {
        return boardGameRepository.existsById(id);
    }

    public BoardGame readById(Integer id) {
        return boardGameRepository.findById(id).orElseThrow(() ->
                new BoardGameNotFoundException(id));
    }
    public List<BoardGame> readAll() {
        return boardGameRepository.findAll();
    }

    public BoardGame update(BoardGame boardGame) {
//        BoardGame orgBoardGame = readById(boardGame.getId());
        return boardGameRepository.save(boardGame);
    }

    public BoardGame deleteById(Integer id) {
        BoardGame boardGame = readById(id);
        boardGameRepository.delete(boardGame);
        return boardGame;
    }
}
