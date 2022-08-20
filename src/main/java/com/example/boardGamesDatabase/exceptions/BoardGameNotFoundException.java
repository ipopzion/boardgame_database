package com.example.boardGamesDatabase.exceptions;

import static java.lang.String.format;

public class BoardGameNotFoundException extends NotFoundException {
    public BoardGameNotFoundException(Integer id) {
        super(format("Board Game #%d does not exist", id));
    }
}
