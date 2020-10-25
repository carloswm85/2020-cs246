package com.example.threadcounting;

import android.util.Log;
import android.widget.Toast;

public class Odd implements Runnable {
    MainActivity activity;

    public Odd(MainActivity mainActivity) {
        activity = mainActivity;
    }

    @Override
    public void run() {
        for (int i = 1; i < 100; i += 2) {

            Log.d("Odd: ", String.valueOf(i));
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        activity.runOnUiThread(() -> {
            // This is the code that will run on the UI thread.
            Toast toast = Toast.makeText(activity, "Odd count finished", Toast. LENGTH_SHORT);
            toast.show();
        });

    }
}
