package com.example.agriguide;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);

        bottomNav.setOnItemSelectedListener(item -> {

            NavHelper.navigate(this, item.getItemId());
            return true;
        });

        ImageView btnMenu = findViewById(R.id.btnMenu);

        btnMenu.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(MainActivity.this, v);
            popup.getMenuInflater().inflate(R.menu.drawer_menu, popup.getMenu());

            popup.setOnMenuItemClickListener(item -> {

                int id = item.getItemId();

                if (id == R.id.menu_profile) {
                    finish(); //
                    return true;
                }

                if (id == R.id.menu_settings) {
                    // open settings activity
                    return true;
                }

                if (id == R.id.menu_about) {
                    // open profile activity
                    return true;
                }

                if (id == R.id.menu_logout) {
                    finish(); //
                    return true;
                }

                return false;
            });

            popup.show();
        });

        ImageView bell = findViewById(R.id.btnNotifications);

        bell.setOnClickListener(v -> {

            com.google.android.material.bottomsheet.BottomSheetDialog sheet =
                    new com.google.android.material.bottomsheet.BottomSheetDialog(MainActivity.this);

            sheet.setContentView(R.layout.sheet_notifications);
            sheet.show();
        });

        String name = "Cherry";
        TextView helloText = findViewById(R.id.helloText);
        helloText.setText("Hello, " + name + " 🌿");

        ImageView buttonToRecommendation = findViewById(R.id.buttonToRecommendation);
        buttonToRecommendation.setOnClickListener(v -> {
            NavHelper.navigate(MainActivity.this, R.id.nav_crops);
        });

        TextView buttonToCalendar = findViewById(R.id.buttonToCalendar);
        buttonToCalendar.setOnClickListener(v -> {
            NavHelper.navigate(MainActivity.this, R.id.nav_calendar);
        });
    }
}