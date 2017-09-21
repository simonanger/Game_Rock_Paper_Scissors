package com.example.simonanger.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class OnePlayerRockPaperScissorsActivity extends AppCompatActivity {

    RockPaperScissorsGame game;

    ImageButton rockButton;
    ImageButton paperButton;
    ImageButton scissorsButton;

    TextView resultText;


    String setFirstName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_player_rock_paper_scissors);

        game = new RockPaperScissorsGame();

        rockButton = (ImageButton) findViewById(R.id.rock_button);
        paperButton = (ImageButton) findViewById(R.id.paper_button);
        scissorsButton = (ImageButton) findViewById(R.id.scissors_button);

        resultText = (TextView) findViewById(R.id.result_text);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        setFirstName = extras.getString("playerOneName");

    }

    public void onHandButtonClicked(View imageButton) {

        if (setFirstName.length() == 0) {
            setFirstName = "Player one";
        }

        HandType playerHand = null;
        if (imageButton == rockButton) playerHand = HandType.ROCK;
        if (imageButton == paperButton) playerHand = HandType.PAPER;
        if (imageButton == scissorsButton) playerHand = HandType.SCISSORS;

        HandType computerHand = game.generatePlayerTwoHand();

        int result = game.playHand(playerHand, computerHand);

        String winnerMessage;

        switch (result) {
            case 0:
                winnerMessage = "It's a draw!"; break;
            case 1:
                winnerMessage = setFirstName + " wins!"; break;
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

//
//
//public class AnswerActivity extends AppCompatActivity {
//
//    TextView questionText;
//    TextView answerText;
//    Answering answers;
//    NumberGenerating randomNumberGenerator;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_answer);
//
//        questionText = (TextView) findViewById(R.id.question_text);
//        answerText = (TextView) findViewById(R.id.answer_text);
//
//        ArrayList<String> customerAnswers = new ArrayList<>();
//        customerAnswers.add("Classic Harrison");
//        customerAnswers.add("Should've been a Jaguar");
//        customerAnswers.add("Wow. - Dan");
//        customerAnswers.add("You've been Robb'd");
//        customerAnswers.add("Work it out yourself");
//
//        answers = new Answers(customerAnswers);
//        randomNumberGenerator = new RandomNumberGenerator();
//
//        Intent intent = getIntent();
//        Bundle extras = intent.getExtras();
//
//        String question = extras.getString("question");
//
//        String answer = answers.getRandomAnswer(randomNumberGenerator);
//
//        questionText.setText(question);
//        answerText.setText(answer);
//    }
//}
