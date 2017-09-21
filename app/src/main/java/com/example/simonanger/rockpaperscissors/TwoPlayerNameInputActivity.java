package com.example.simonanger.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TwoPlayerNameInputActivity extends AppCompatActivity {

    EditText playerOneNameText;
    EditText playerTwoNameText;
    Button twoPlayerGameStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player_name_input);

        playerOneNameText = (EditText) findViewById(R.id.player_one_name_input);
        playerTwoNameText = (EditText) findViewById(R.id.player_two_name_input);
        twoPlayerGameStartButton = (Button) findViewById(R.id.start_two_player_game_button);

    }

    public void onTwoPlayerGameButtonClicked(View button) {
        Intent intent = new Intent(this, TwoPlayerRockPaperScissorsActivity.class);

        String playerOneName = playerOneNameText.getText().toString();
        String playerTwoName = playerTwoNameText.getText().toString();

        Bundle extras = new Bundle();
        extras.putString("playerOneName",playerOneName);
        extras.putString("playerTwoName",playerTwoName);
        intent.putExtras(extras);
        startActivity(intent);


    }
}