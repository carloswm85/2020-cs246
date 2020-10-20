package byui.cs246.lfalin.prove05;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity {

    String _book;
    String _chapter;
    String _verse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();

        // By using static constants as the key names rather than bare strings,
        // we guard against typos. If I had accidentally typed:
        //
        // getStringExtra("CHAPTR") or
        // getStringExtra("chapter")
        //
        // the program would have compiled and run fine, but we would have failed
        // to retrieve the chapter string. However, by using constant names, if I type:
        //
        // getStringExtra(MainActivity.CHAPTR_PART)
        //
        // The compiler would catch that error, because there is no const named CHAPTR_PART.
        //
        // It's always better to let the compiler catch errors whenever possible.
        _book = intent.getStringExtra(MainActivity.BOOK_PART);
        _chapter = intent.getStringExtra(MainActivity.CHAPTER_PART);
        _verse = intent.getStringExtra(MainActivity.VERSE_PART);

        String scripture = String.format("%s %s:%s", _book, _chapter, _verse);

        Log.d(getClass().getName(), String.format("Received intent with %s", scripture));

        TextView scriptureLabel = (TextView) findViewById(R.id.lblScripture);
        scriptureLabel.setText(scripture);
    }

    public void onSaveScripture(View theButton) {

        // See https://developer.android.com/training/basics/data-storage/shared-preferences.html
        SharedPreferences sharedPrefs = getSharedPreferences(MainActivity.APP_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();

        editor.putString(MainActivity.BOOK_PART, _book);
        editor.putString(MainActivity.CHAPTER_PART, _chapter);
        editor.putString(MainActivity.VERSE_PART, _verse);

        // Why apply() and not commit() ?
        // See: http://stackoverflow.com/questions/5960678/whats-the-difference-between-commit-and-apply-in-shared-preference
        editor.apply();

        // See https://developer.android.com/guide/topics/ui/notifiers/toasts.html
        Toast.makeText(this, "Scripture has been saved.", Toast.LENGTH_SHORT).show();
    }
}
