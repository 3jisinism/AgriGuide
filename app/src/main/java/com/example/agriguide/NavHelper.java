package com.example.agriguide;

import android.content.Context;
import android.content.Intent;

public class NavHelper {

    public static void navigate(Context context, int itemId) {
        Intent intent = null;

        if (itemId == R.id.nav_home) {
            intent = new Intent(context, MainActivity.class);
        } else if (itemId == R.id.nav_crops) {
            intent = new Intent(context, RecommendationActivity.class);
        } else if (itemId == R.id.nav_calendar) {
            intent = new Intent(context, CalendarActivity.class);
        } else if (itemId == R.id.nav_reminders) {
            intent = new Intent(context, RemindersActivity.class);
        } else if (itemId == R.id.nav_market) {
            intent = new Intent(context, MarketActivity.class);
        }

        if (intent != null) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            context.startActivity(intent);
        }
    }
}