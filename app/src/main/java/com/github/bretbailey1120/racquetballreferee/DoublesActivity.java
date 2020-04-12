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
public class DoublesActivity extends AppCompatActivity {


    // Tracks the score for Team A
    int scoreTeamA = 0;

    // Tracks the score for Team B
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doubles);

        setNamesFromSettings();
    }

    /**
     * Resets the score for both teams back to 0.
     */
    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.teamAScore);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.teamBScore);
        scoreView.setText(String.valueOf(score));
    }

    public void addOneForTeamA(View v) {
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
    }

    public void technicalFoulForTeamA(View v) {
        scoreTeamA -= 1;
        displayForTeamA(scoreTeamA);
    }

    public void addOneForTeamB(View v) {
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);
    }

    public void technicalFoulForTeamB(View v) {
        scoreTeamB -= 1;
        displayForTeamB(scoreTeamB);
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

        String nameFour = sharedPrefs.getString(
                getString(R.string.player_four_key),
                getString(R.string.player_four));

        TextView playerOneName = (TextView) findViewById(R.id.teamOne);
        playerOneName.setText(nameOne + " & " + nameTwo);

        TextView playerTwoName = (TextView) findViewById(R.id.teamTwo);
        playerTwoName.setText(nameThree + " & " + nameFour);
    }
}
