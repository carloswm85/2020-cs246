package com.example.teamactivity06;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

public class Even implements Runnable {
    Activity activity;

    public Even (Activity ac){
        activity= ac;
    }


    @Override
    public void run() {
        for (int i = 0; i <= 100; i += 2) {
            //System.out.println(i);
            Log.d("Even", String.valueOf(i));
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // This is the code that will run on the UI thread.
                Toast toast = Toast.makeText(activity, "Even Counting Finished", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
