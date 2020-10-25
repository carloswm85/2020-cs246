package com.example.teamactivity06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void countEven(View v){
        Even e = new Even(this);
        Thread t = new Thread(e,"EVEN");
        t.start();

    }
    public void countOdd(View v) {
        Odd o = new Odd(this);
        Thread t = new Thread(o, "ODD");
        t.start();
    }
}
