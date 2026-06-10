package com.example.agriguide;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RecommendationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recommendation);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Back button
        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
                    Intent intent = new Intent(RecommendationActivity.this,
                            MainActivity.class);
                    startActivity(intent);
                });

        // Spinner
        Spinner locationSpinner;
        locationSpinner = findViewById(R.id.locationSpinner);

        String[] cities = {
                "Tacloban City",
                "Ormoc City",
                "Baybay City",
                "Calbayog City"
        };

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                cities
        );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );
        locationSpinner.setAdapter(adapter);

        Button buttonToGuide = findViewById(R.id.buttonToGuide);
        buttonToGuide.setOnClickListener(v -> {
            Intent intent = new Intent(RecommendationActivity.this,
                    GuideActivity.class);
            startActivity(intent);
        });

    }
}