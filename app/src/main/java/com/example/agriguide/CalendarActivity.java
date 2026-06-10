package com.example.agriguide;

import static com.example.agriguide.R.id.nav_calendar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calendar);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);

        bottomNav.setSelectedItemId(nav_calendar);

        bottomNav.setOnItemSelectedListener(item -> {
            if (item.getItemId() != nav_calendar) {
                NavHelper.navigate(this, item.getItemId());
            }
            return true;
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Calendar
        CalendarView calendarView = findViewById(R.id.calendarView);
        calendarView.setDate(System.currentTimeMillis(), false, true);

        bottomNav.setSelectedItemId(nav_calendar);
    }
}