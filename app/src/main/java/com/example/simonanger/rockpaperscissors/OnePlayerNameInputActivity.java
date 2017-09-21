package com.example.simonanger.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OnePlayerNameInputActivity extends AppCompatActivity {

    EditText playerOneNameText;
    Button onePlayerGameStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_player_name_input);

        playerOneNameText = (EditText) findViewById(R.id.player_one_name_input);
        onePlayerGameStartButton = (Button) findViewById(R.id.start_game_button);

    }

    public void onGameButtonClicked(View button) {
        Intent intent = new Intent(this, OnePlayerRockPaperScissorsActivity.class);

        String playerOneName = playerOneNameText.getText().toString();
        intent.putExtra("playerOneName", playerOneName);

        startActivity(intent);
    }
}
