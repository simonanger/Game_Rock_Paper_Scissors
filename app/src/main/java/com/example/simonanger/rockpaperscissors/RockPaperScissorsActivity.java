package com.example.simonanger.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class RockPaperScissorsActivity extends AppCompatActivity {

    RockPaperScissorsGame game;

    ImageButton rockButton;
    ImageButton paperButton;
    ImageButton scissorsButton;

    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);

        game = new RockPaperScissorsGame();

        rockButton = (ImageButton) findViewById(R.id.rock_button);
        paperButton = (ImageButton) findViewById(R.id.paper_button);
        scissorsButton = (ImageButton) findViewById(R.id.scissors_button);

        resultText = (TextView) findViewById(R.id.result_text);
    }

    public void onHandButtonClicked(View imageButton) {
        HandType playerHand = null;
        if (imageButton == rockButton) playerHand = HandType.ROCK;
        if (imageButton == paperButton) playerHand = HandType.PAPER;
        if (imageButton == scissorsButton) playerHand = HandType.SCISSORS;

        HandType computerHand = game.generateComputerHand();

        int result = game.playHand(playerHand, computerHand);

        String winnerMessage;

        switch (result) {
            case 0:
                winnerMessage = "It's a draw!"; break;
            case 1:
                winnerMessage = "You win!"; break;
            case 2:
                winnerMessage = "Computer wins! Better luck next time."; break;
            default:
                winnerMessage = "ERROR.";
        }

        if (playerHand == null) {
            resultText.setText(winnerMessage);
            return;
        }

        String resultMessage = "You played " + playerHand.name() + "!\n"
                + "Computer played " + computerHand.name() + "!\n"
                + winnerMessage;

        resultText.setText(resultMessage);
    }
}
