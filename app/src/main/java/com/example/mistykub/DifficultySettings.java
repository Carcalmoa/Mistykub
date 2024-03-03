package com.example.mistykub;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class DifficultySettings extends AppCompatActivity {
    private RadioGroup difficultyRadioGroup;
    private Button startGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.difficulty_settings);

        difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup);
        startGameButton = findViewById(R.id.startGameButton);

        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = difficultyRadioGroup.getCheckedRadioButtonId();

                if (selectedId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String difficulty = selectedRadioButton.getText().toString();

                    int difficultyValue;

                    // Assign the appropriate value based on the selected difficulty
                    switch (difficulty.toLowerCase()) {
                        case "easy":
                            difficultyValue = 45;
                            break;
                        case "medium":
                            difficultyValue = 50;
                            break;
                        case "hard":
                            difficultyValue = 60;
                            break;
                        default:
                            difficultyValue = 50; // by default the medium difficulty
                            break;
                    }

                    Toast.makeText(DifficultySettings.this, "Selected Difficulty: " + difficulty, Toast.LENGTH_SHORT).show();

                    // Pass the difficulty value to the Board activity
                    Intent intent = new Intent(DifficultySettings.this, Board.class);
                    intent.putExtra("difficultyValue", difficultyValue);
                    startActivity(intent);
                } else {
                    Toast.makeText(DifficultySettings.this, "Please select a difficulty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Add your startGame method if needed
}