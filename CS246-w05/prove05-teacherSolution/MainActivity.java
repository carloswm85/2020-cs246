package byui.cs246.lfalin.prove05;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // These are the constant values we'll be using for keys throughout the application
    // They're put here for simplicity, but in RealLife™ we'd store them as string resources
    // See: https://developer.android.com/guide/topics/resources/string-resource.html
    public static final String BOOK_PART = "BOOK_PART";
    public static final String CHAPTER_PART = "CHAPTER_PART";
    public static final String VERSE_PART = "VERSE_PART";

    public static final String APP_PREFS = "APPLICATION_PREFERENCES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Favorite Scripture");
    }

    // Some of you might have used OnClickListener rather than binding the click handler
    // directly in the XML layout. See this SO post for an explanation of the differences:
    // http://stackoverflow.com/questions/21319996/android-onclick-in-xml-vs-onclicklistener
    public void onDisplayScripture(View theButton) {

        EditText txtBook = (EditText) findViewById(R.id.txtBook);
        EditText txtChapter = (EditText) findViewById(R.id.txtChapter);
        EditText txtVerse = (EditText) findViewById(R.id.txtVerse);

        String book = txtBook.getText().toString();
        String chapter = txtChapter.getText().toString();
        String verse = txtVerse.getText().toString();

        String scripture = String.format("%s %s:%s", book, chapter, verse);
        Log.d(getClass().getName(), String.format("About to create intent with %s", scripture));

        // Some of you might have used a bundle rather than putExtra(). You can see a discussion
        // of the differences here:
        // http://stackoverflow.com/questions/15243798/advantages-of-using-bundle-instead-of-direct-intent-putextra-in-android
        Intent scriptureIntent = new Intent(this, DisplayActivity.class);
        scriptureIntent.putExtra(BOOK_PART, book);
        scriptureIntent.putExtra(CHAPTER_PART, chapter);
        scriptureIntent.putExtra(VERSE_PART, verse);

        startActivity(scriptureIntent);
    }

    public void onLoadScripture(View theButton) {

        // See https://developer.android.com/training/basics/data-storage/shared-preferences.html
        SharedPreferences sharedPref = getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);

        // Get the book, or return null if it isn't there.
        String book = sharedPref.getString(BOOK_PART, null);
        String chapter = sharedPref.getString(CHAPTER_PART, null);
        String verse = sharedPref.getString(VERSE_PART, null);

        if(book == null) {
            Toast.makeText(this, "No saved scripture found.", Toast.LENGTH_SHORT).show();
        }
        else {
            EditText txtBook = (EditText) findViewById(R.id.txtBook);
            EditText txtChapter = (EditText) findViewById(R.id.txtChapter);
            EditText txtVerse = (EditText) findViewById(R.id.txtVerse);

            txtBook.setText(book);
            txtChapter.setText(chapter);
            txtVerse.setText(verse);

            // See https://developer.android.com/guide/topics/ui/notifiers/toasts.html
            Toast.makeText(this, "Loaded scripture.", Toast.LENGTH_SHORT).show();
        }


    }
}
