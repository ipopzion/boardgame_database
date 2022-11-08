package com.example.boardGamesDatabase.controllers;

import com.example.boardGamesDatabase.entities.BoardGame;
import com.example.boardGamesDatabase.services.BoardGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://alfred-boardgames.netlify.app/")
@RequestMapping("/boardgames/api/v1")
public class BoardGameController {

    @Autowired
    private BoardGameService boardGameService;

    @PostMapping
    public BoardGame create(@RequestBody BoardGame boardGame) {
        return boardGameService.create(boardGame);
    }

    @GetMapping(value = "/{id}/exists")
    public boolean existsById(@PathVariable Integer id) {
        return boardGameService.existsById(id);
    }

    @GetMapping(value = "/{id}/details")
    public BoardGame readById(@PathVariable Integer id) {
        return boardGameService.readById(id);
    }

    @GetMapping(value = "/all")
    public List<BoardGame> readAll() {
        return boardGameService.readAll();
    }

    @PutMapping()
    public BoardGame update(@RequestBody BoardGame boardGame) {
        return boardGameService.update(boardGame);
    }

    @DeleteMapping(value = "/{id}")
    public BoardGame deleteById(@PathVariable Integer id) {
        return boardGameService.deleteById(id);
    }

    @GetMapping(value = "/test")
    public String test() {
        return "Hello World";
    }
}
