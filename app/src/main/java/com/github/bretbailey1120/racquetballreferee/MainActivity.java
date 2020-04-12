package com.github.bretbailey1120.racquetballreferee;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This activity keeps track of the racquetball score.
 */
public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupSharedPreferences();

        // Find the View that shows the singles category
        TextView singles = (TextView) findViewById(R.id.singles);

        // Set a click listener on that View
        singles.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the singles category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the singlesIntent
                Intent singlesIntent = new Intent(MainActivity.this, SinglesActivity.class);

                // Start the new activity
                startActivity(singlesIntent);
            }
        });

        // Find the View that shows the doubles category
        TextView doubles = (TextView) findViewById(R.id.doubles);

        // Set a click listener on that View
        doubles.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the doubles category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the doublesIntent
                Intent doublesIntent = new Intent(MainActivity.this, DoublesActivity.class);

                // Start the new activity
                startActivity(doublesIntent);
            }
        });

        // Find the View that shows the doubles category
        TextView cutThroat = (TextView) findViewById(R.id.cutThroat);

        // Set a click listener on that View
        cutThroat.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the doubles category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the doublesIntent
                Intent cutThroatIntent = new Intent(MainActivity.this, CutThroatActivity.class);

                // Start the new activity
                startActivity(cutThroatIntent);
            }
        });
    }

    private void setupSharedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        // do nothing
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PreferenceManager.getDefaultSharedPreferences(this)
                .unregisterOnSharedPreferenceChangeListener(this);
    }
}
