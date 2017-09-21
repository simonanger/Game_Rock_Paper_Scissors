package com.example.simonanger.rockpaperscissors;

import java.util.EnumMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by simonanger on 21/09/2017.
 */

public class RockPaperScissorsGame {
    Map<HandType, HandType> winners = new EnumMap<>(HandType.class);

    public RockPaperScissorsGame() {
        winners.put(HandType.ROCK, HandType.SCISSORS);
        winners.put(HandType.PAPER, HandType.ROCK);
        winners.put(HandType.SCISSORS, HandType.PAPER);
    }

    public int playHand(HandType playerHand, HandType playerTwoHand) {
        if (playerHand == null) return -1;

        if (playerHand == playerTwoHand) return 0;

        if (winners.get(playerHand) == playerTwoHand) return 1;

        if (winners.get(playerTwoHand) == playerHand) return 2;

        return -1;
    }

    public HandType generatePlayerTwoHand() {
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        return HandType.values()[randomNumber];
    }
}
