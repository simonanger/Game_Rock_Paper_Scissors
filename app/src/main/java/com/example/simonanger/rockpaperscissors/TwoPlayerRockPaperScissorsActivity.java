package com.example.simonanger.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;


public class TwoPlayerRockPaperScissorsActivity extends AppCompatActivity {

    RockPaperScissorsGame game;

    ImageButton rockButton;
    ImageButton paperButton;
    ImageButton scissorsButton;

    TextView resultText;
    TextView selectGuideText;

    ArrayList<HandType> playerChoices;
    String setFirstName;
    String setSecondName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player_rock_paper_scissors);

        game = new RockPaperScissorsGame();

        rockButton = (ImageButton) findViewById(R.id.rock_button);
        paperButton = (ImageButton) findViewById(R.id.paper_button);
        scissorsButton = (ImageButton) findViewById(R.id.scissors_button);

        resultText = (TextView) findViewById(R.id.result_text);
        selectGuideText = (TextView) findViewById(R.id.select_guide_text);

        Bundle extras = getIntent().getExtras();
        setFirstName = extras.getString("playerOneName");
        setSecondName = extras.getString("playerTwoName");

        if (setFirstName.length() == 0) {
            setFirstName = "Player one";
        }

        if (setSecondName.length() == 0) {
            setSecondName = "Player two";
        }

        playerChoices = new ArrayList<>();

    }

    public void onHandButtonClicked(View imageButton) {

        // if playerChoices is empty, just add a choice
        // else if playerChoices already has one choice, add a choice, then do the game compare bit

        HandType playerHand = null;
        if (imageButton == rockButton) playerHand = HandType.ROCK;
        if (imageButton == paperButton) playerHand = HandType.PAPER;
        if (imageButton == scissorsButton) playerHand = HandType.SCISSORS;

        if (playerChoices.size() == 0) {
            playerChoices.add(playerHand);
            selectGuideText.setText("Player two, " +
                    "select your hand from the images above.");
            return;
        }

        playerChoices.add(playerHand);


        int result = game.playHand(playerChoices.get(0), playerChoices.get(1));

        String winnerMessage;

        switch (result) {
            case 0:
                winnerMessage = "It's a draw!"; break;
            case 1:
                winnerMessage = setFirstName + " wins!"; break;
            case 2:
                winnerMessage = setSecondName + " wins!"; break;
            default:
                winnerMessage = "ERROR.";
        }

        if (playerHand == null) {
            resultText.setText(winnerMessage);
            return;
        }

        String resultMessage = setFirstName + " played " + playerChoices.get(0).name() + "!\n"
                + setSecondName + " played " + playerChoices.get(1).name() + "!\n"
                + winnerMessage;



        resultText.setText(resultMessage);
        selectGuideText.setText("To play again, pass back to player one and make a choice");
    }
}


//    Intent intent = new Intent(this, TwoPlayerRockPaperScissorsActivity.class);
//
//    String playerOneName = playerOneNameText.getText().toString();
//    String playerTwoName = playerTwoNameText.getText().toString();
//
//    Bundle extras = new Bundle();
//        extras.putString("playerOneName",playerOneName);
//                extras.putString("playerTwoName",playerTwoName);
//                intent.putExtras(extras);
//                startActivity(intent);

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
