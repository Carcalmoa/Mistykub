package com.example.mistykub;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;


import android.view.WindowManager;
import android.widget.Button;

public class NewGame extends AppCompatActivity {
    private Button newGameButton;
    private ImageButton configButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_game);

        configButton = findViewById(R.id.configButton);
        newGameButton = findViewById(R.id.newGameButton);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startNewGame();
            }
        });
        configButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDifficultySettings();
            }
        });
    }

    private void startNewGame() {
        Intent intent = new Intent(NewGame.this, Board.class);
        startActivity(intent);
    }
    private void openDifficultySettings() {
        Intent intent = new Intent(NewGame.this, DifficultySettings.class);
        startActivity(intent);
    }

}