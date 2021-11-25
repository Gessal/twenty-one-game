package com.example.twentyonegame.controller;

import com.example.twentyonegame.dto.CardDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    @PostMapping("/startGame")
    public ResponseEntity<String> startGame() {
        return new ResponseEntity<>("start game", HttpStatus.OK);
    }

    @PostMapping("/takeCard")
    public ResponseEntity<CardDTO> takeCard(HttpSession session) {
        List<CardDTO> cards = new ArrayList<>();
        cards.add(new CardDTO("Туз черви"));
        session.setAttribute("cards", cards);
        return new ResponseEntity<>(new CardDTO("Туз черви"), HttpStatus.OK);
    }

    @PostMapping("/openCards")
    public ResponseEntity<List<CardDTO>> openCards(HttpSession session) {
        List<CardDTO> cards = new ArrayList<>();
        cards.add(new CardDTO("Туз пик"));
        cards.add(new CardDTO("Туз черви"));
        cards.add(new CardDTO("Туз буби"));
        cards.add(new CardDTO("Туз крести"));
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }
}
