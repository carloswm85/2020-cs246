package com.example.prove05_activitiesandintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity {

    String _book;
    String _chapter;
    String _verse;
    public static final String TAG = "CarlosActivityIntentReception";
    String FileName = "myFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_activity);

        Intent intent = getIntent();
        _book = intent.getStringExtra(MainActivity.BOOK_PART);
        _chapter = intent.getStringExtra(MainActivity.CHAPTER_PART);
        _verse = intent.getStringExtra(MainActivity.VERSE_PART);

        String logcatMessage = "Received intent with " + _book + " " + _chapter + ": " + _verse;
        Log.d(TAG, logcatMessage);

        TextView scriptureLabel = findViewById(R.id.lblScripture);
        String passage = _book + " " + _chapter + ": " + _verse;
        scriptureLabel.setText(passage);
    }

    public void onSaveScripture(View view) {
        SharedPreferences sharedPref = getSharedPreferences(FileName, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("book", _book);
        editor.putString("chapter", _chapter);
        editor.putString("verse", _verse);
        editor.commit();

        Toast.makeText(this, "Information successfully saved to your device.", Toast.LENGTH_SHORT). show();

//        Context context = getApplicationContext();
//        CharSequence toast_text = "The scripture has been successfully saved to your device.";
//        int toast_duration = Toast.LENGTH_SHORT;
//
//        Toast toast = Toast.makeText(context, toast_text, toast_duration);
//        toast.show();
    }
}