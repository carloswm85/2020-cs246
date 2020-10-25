package com.example.threadcounting;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    WeakReference<Even> weakReference;
    Thread threadEven;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void countEven(View view) {
        Even even = new Even(this);
        if(weakReference != null) {
            threadEven = new Thread(even, "EVEN");
            threadEven.start();
        } else {
            // Nothing
        }
    }

    public void countOdd(View view) {
        Odd odd = new Odd(this);
        Thread t = new Thread(odd, "ODD");
        t.start();
    }

    public void interruptEven(View view) {
        threadEven.interrupt();
    }
}