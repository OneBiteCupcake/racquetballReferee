package com.github.bretbailey1120.racquetballreferee;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This activity keeps track of the basketball score for 2 teams.
 */
public class CutThroatActivity extends AppCompatActivity {


    // Tracks the score for Team A
    int scorePlayerOne = 0;

    // Tracks the score for Team B
    int scorePlayerTwo = 0;

    // Tracks the score for Team B
    int scorePlayerThree = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cut_throat);

        setNamesFromSettings();
    }

    /**
     * Resets the score for both teams back to 0.
     */
    public void resetScore(View v) {
        scorePlayerOne = 0;
        scorePlayerTwo = 0;
        scorePlayerThree = 0;
        displayForPlayerOne(scorePlayerOne);
        displayForPlayerTwo(scorePlayerTwo);
        displayForPlayerThree(scorePlayerThree);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForPlayerOne(int score) {
        TextView scoreView = (TextView) findViewById(R.id.playerOneScore);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForPlayerTwo(int score) {
        TextView scoreView = (TextView) findViewById(R.id.playerTwoScore);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForPlayerThree(int score) {
        TextView scoreView = (TextView) findViewById(R.id.playerThreeScore);
        scoreView.setText(String.valueOf(score));
    }

    public void addOneForPlayerOne(View v) {
        scorePlayerOne += 1;
        displayForPlayerOne(scorePlayerOne);
    }

    public void technicalFoulForPlayerOne(View v) {
        scorePlayerOne -= 1;
        displayForPlayerOne(scorePlayerOne);
    }

    public void addOneForPlayerTwo(View v) {
        scorePlayerTwo += 1;
        displayForPlayerTwo(scorePlayerTwo);
    }

    public void technicalFoulForPlayerTwo(View v) {
        scorePlayerTwo -= 1;
        displayForPlayerTwo(scorePlayerTwo);
    }

    public void addOneForPlayerThree(View v) {
        scorePlayerThree += 1;
        displayForPlayerThree(scorePlayerThree);
    }

    public void technicalFoulForPlayerThree(View v) {
        scorePlayerThree -= 1;
        displayForPlayerThree(scorePlayerThree);
    }

    public void setNamesFromSettings() {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String nameOne = sharedPrefs.getString(
                getString(R.string.player_one_key),
                getString(R.string.player_one));

        String nameTwo = sharedPrefs.getString(
                getString(R.string.player_two_key),
                getString(R.string.player_two));

        String nameThree = sharedPrefs.getString(
                getString(R.string.player_three_key),
                getString(R.string.player_three));

        TextView playerOneName = (TextView) findViewById(R.id.cutThroatPlayerOne);
        playerOneName.setText(nameOne);

        TextView playerTwoName = (TextView) findViewById(R.id.cutThroatPlayerTwo);
        playerTwoName.setText(nameTwo);

        TextView playerThreeName = (TextView) findViewById(R.id.cutThroatPlayerThree);
        playerThreeName.setText(nameThree);
    }
}
