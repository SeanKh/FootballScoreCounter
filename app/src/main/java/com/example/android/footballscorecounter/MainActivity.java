package com.example.android.footballscorecounter;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView image1;
    private ImageView image2;
    private String[] teams;
    private Spinner spinner1;
    private Spinner spinner2;
    private TypedArray imgs;

    int scoreTeamA=0;
    int foulTeamA=0;
    int cornerTeamA=0;

    int scoreTeamB=0;
    int foulTeamB=0;
    int cornerTeamB=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teams = getResources().getStringArray(R.array.team_list);
        imgs = getResources().obtainTypedArray(R.array.team_flag_list);

        image1 = (ImageView) findViewById(R.id.teamA_image);
        spinner1 = (Spinner) findViewById(R.id.teamA_spinner);

        image2 = (ImageView) findViewById(R.id.teamB_image);
        spinner2 = (Spinner) findViewById(R.id.teamB_spinner);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, teams);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter);

        spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                image1.setImageResource(imgs.getResourceId(
                        spinner1.getSelectedItemPosition(), -1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
        spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                image2.setImageResource(imgs.getResourceId(
                        spinner2.getSelectedItemPosition(), -1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayGoalForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayFoulForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_foul);
        scoreView.setText(String.valueOf(score));
    }

    public void displayCornerForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_corner);
        scoreView.setText(String.valueOf(score));
    }

    public void displayGoalForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayFoulForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_foul);
        scoreView.setText(String.valueOf(score));
    }

    public void displayCornerForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_corner);
        scoreView.setText(String.valueOf(score));
    }

    public void goalAdd_TeamA(View view)
    {
        scoreTeamA+=1;
        displayGoalForTeamA(scoreTeamA);
    }

    public void foulAdd_TeamA(View view)
    {
        foulTeamA+=1;
        displayFoulForTeamA(foulTeamA);
    }

    public void cornerAdd_TeamA(View view)
    {
        cornerTeamA+=1;
        displayCornerForTeamA(cornerTeamA);
    }

    public void goalMinus_TeamA(View view)
    {
        if(scoreTeamA==0){
            Toast.makeText(this, "It cannot be less than 0", Toast.LENGTH_SHORT).show();
            return;
        }
        scoreTeamA-=1;
        displayGoalForTeamA(scoreTeamA);
    }

    public void foulMinus_TeamA(View view)
    {
        if(foulTeamA==0){
            Toast.makeText(this, "It cannot be less than 0", Toast.LENGTH_SHORT).show();
            return;
        }
        foulTeamA-=1;
        displayFoulForTeamA(foulTeamA);
    }

    public void cornerMinus_TeamA(View view)
    {
        if(cornerTeamA==0){
            Toast.makeText(this, "It cannot be less than 0", Toast.LENGTH_SHORT).show();
            return;
        }
        cornerTeamA-=1;
        displayCornerForTeamA(cornerTeamA);
    }

    /*For Team B*/
    public void goalAdd_TeamB(View view)
    {
        scoreTeamB+=1;
        displayGoalForTeamB(scoreTeamB);
    }

    public void foulAdd_TeamB(View view)
    {
        foulTeamB+=1;
        displayFoulForTeamB(foulTeamB);
    }

    public void cornerAdd_TeamB(View view)
    {
        cornerTeamB+=1;
        displayCornerForTeamB(cornerTeamB);
    }

    public void goalMinus_TeamB(View view)
    {
        if(scoreTeamB==0){
            Toast.makeText(this, "It cannot be less than 0", Toast.LENGTH_SHORT).show();
            return;
        }
        scoreTeamB-=1;
        displayGoalForTeamB(scoreTeamB);
    }

    public void foulMinus_TeamB(View view)
    {
        if(foulTeamB==0){
            Toast.makeText(this, "It cannot be less than 0", Toast.LENGTH_SHORT).show();
            return;
        }
        foulTeamB-=1;
        displayFoulForTeamB(foulTeamB);
    }

    public void cornerMinus_TeamB(View view)
    {
        if(cornerTeamB==0){
            Toast.makeText(this, "It cannot be less than 0", Toast.LENGTH_SHORT).show();
            return;
        }
        cornerTeamB-=1;
        displayCornerForTeamB(cornerTeamB);
    }

    public void reset(View v)
    {
        scoreTeamA=0;
        foulTeamA=0;
        cornerTeamA=0;
        displayGoalForTeamA(scoreTeamA);
        displayFoulForTeamA(foulTeamA);
        displayCornerForTeamA(cornerTeamA);

        scoreTeamB=0;
        foulTeamB=0;
        cornerTeamB=0;
        displayGoalForTeamB(scoreTeamB);
        displayFoulForTeamB(foulTeamB);
        displayCornerForTeamB(cornerTeamB);

    }
}
