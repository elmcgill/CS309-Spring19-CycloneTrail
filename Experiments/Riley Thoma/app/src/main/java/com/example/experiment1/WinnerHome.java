package com.example.experiment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WinnerHome extends AppCompatActivity {

    String name, email;
    int age;

    EditText nameInput;
    EditText emailInput;
    EditText ageInput;

    Button submitButton, homeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        ageInput = findViewById(R.id.ageInput);

        homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WinnerHome.this, MainActivity.class);
                startActivity(i);
            }
        });

        submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nameInput.getText().toString();
                email = emailInput.getText().toString();
                age = Integer.valueOf(ageInput.getText().toString());


                Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), email, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), String.valueOf(age), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
