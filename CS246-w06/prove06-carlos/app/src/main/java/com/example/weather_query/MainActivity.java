package com.example.weather_query;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;


/**
 * This app receives <code>location</code> as input, and outputs current temperature for that
 * location, through the <code>showTemp</code> method; and outputs forecast for that location,
 * through the <code>showForecast</code> method.
 * @author Carlos Mercado
 * @see CurrentTemperature
 * @see WeatherConditions
 */
public class MainActivity extends AppCompatActivity {

    // TAG used in the Logcat.
    public static final String TAG = "CWM_MYAPP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Retrieves location input from the main UI activity.
    private String locationName() {
        EditText txtLocation = findViewById(R.id.locationName);
        return txtLocation.getText().toString();
    }

    /**
     * Starts a background thread, which retrieves the current temperature for the desired
     * <code>location</code>. The value is returned to a Toast instance.
     * @param view current view in the UI.
     * @see CurrentTemperature runnable class, used for getting current temperature from internet
     * weather API.
     */
    public void showTemp(View view) {
        String location = locationName();
        CurrentTemperature current = new CurrentTemperature(MainActivity.this, location);
        Thread localThread = new Thread(current);
        localThread.start();

        // Logcat and toast, part of the assignmentm used for development and testing.

//        String LogcatMessage = "> LOGCAT: showTemp: location: " + location;
//        Log.d(TAG, LogcatMessage);

//        Toast toast = Toast.makeText(this.getApplicationContext(), "> TOAST: showTemp: location: " + location, Toast.LENGTH_SHORT);
//        toast.show();
    }

    /**
     * Starts a background thread, which retrieves the weather forecast for the desired
     * <code>location</code>.
     * The value is returned to ListView component in the main UI.
     * @param view current view in the UI.
     * @see CurrentForecast
     */
    public void showForecast(View view) {
        String location = locationName();
        ListView list = findViewById(R.id.list);
        CurrentForecast current = new CurrentForecast(list, location);
        Thread localThread = new Thread(current);
        localThread.start();
//
//        // Logcat and toast, part of the assignmentm used for development and testing.
//
////        String LogcatMessage = "> LOGCAT: ShowForecast: City: " + city;
////        Log.d(TAG, LogcatMessage);
////
////        Toast toast = Toast.makeText(this.getApplicationContext(), "> TOAST: ShowForecast: City: " + city, Toast.LENGTH_SHORT);
////        toast.show();
    }
}