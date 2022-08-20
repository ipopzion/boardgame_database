package com.example.boardGamesDatabase.repositories;

import com.example.boardGamesDatabase.entities.BoardGame;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface BoardGameRepository extends MongoRepository<BoardGame, Integer> {
}
