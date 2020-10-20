package com.example.prove05_activitiesandintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.SecurityPermission;

public class MainActivity extends AppCompatActivity {

    public static final String BOOK_PART = "BOOK_PART";
    public static final String CHAPTER_PART = "CHAPTER_PART";
    public static final String VERSE_PART = "VERSE_PART";
    public static final String TAG = "CarlosActivityIntentCreation";
    String FileName = "myFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Favorite Scripture");

//        Button button = (Button) findViewById(R.id.btnDisplay);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onDisplayScripture();
//            }
//        });
    }

    public void onDisplayScripture(View button) {
        EditText txtBook = findViewById(R.id.txtBook);
        EditText txtChapter = findViewById(R.id.txtChapter);
        EditText txtVerse = findViewById(R.id.txtVerse);

        String book = txtBook.getText().toString();
        String chapter = txtChapter.getText().toString();
        String verse = txtVerse.getText().toString();

        String logcatMessage = "About to create intent with " + book + " " + chapter + ": " + verse;
        Log.d(TAG, logcatMessage);

        Intent scriptureIntent = new Intent(this, DisplayActivity.class);

        scriptureIntent.putExtra(BOOK_PART, book);
        scriptureIntent.putExtra(CHAPTER_PART, chapter);
        scriptureIntent.putExtra(VERSE_PART, verse);

        startActivity(scriptureIntent);
    }

    public void onLoadScripture(View view) {
        SharedPreferences sharedPref = getSharedPreferences(FileName, Context.MODE_PRIVATE);

        String defaultValue = "DefaultValue";
        String book = sharedPref.getString("book", defaultValue);
        String chapter = sharedPref.getString("chapter", defaultValue);
        String verse = sharedPref.getString("verse", defaultValue);

        EditText txtBook = findViewById(R.id.txtBook);
        EditText txtChapter = findViewById(R.id.txtChapter);
        EditText txtVerse = findViewById(R.id.txtVerse);

        txtBook.setText(book);
        txtChapter.setText(chapter);
        txtVerse.setText(verse);

        Toast.makeText(this, "Information loaded from memory.", Toast.LENGTH_SHORT). show();
    }
}