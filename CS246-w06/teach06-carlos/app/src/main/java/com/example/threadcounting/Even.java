package com.example.threadcounting;

import android.util.Log;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class Even implements Runnable {
    MainActivity mainActivity;
    WeakReference<Even> referenceEven;

    public Even(MainActivity mainActivityConstructor) {
        mainActivity = mainActivityConstructor;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i += 2) {
            Log.d("Even: ", String.valueOf(i));
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        mainActivity.runOnUiThread(() -> {
            // This is the code that will run on the UI thread.
            Toast toast = Toast.makeText(mainActivity, "Even count finished", Toast.LENGTH_SHORT);
            toast.show();
        });
    }
}
