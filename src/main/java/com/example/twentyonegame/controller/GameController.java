package com.example.twentyonegame.controller;

import com.example.twentyonegame.dto.Card;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    @PostMapping("/takeCard")
    public ResponseEntity<Card> takeCard() {
        return new ResponseEntity<>(new Card("Туз черви"), HttpStatus.OK);
    }

    @PostMapping("/openCards")
    public ResponseEntity<List<Card>> openCards() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("Туз пик"));
        cards.add(new Card("Туз черви"));
        cards.add(new Card("Туз буби"));
        cards.add(new Card("Туз крести"));
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }
}
