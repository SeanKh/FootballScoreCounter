package com.example.android.footballscorecounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int foulTeamA = 0;
    int cornerTeamA = 0;

    int scoreTeamB = 0;
    int foulTeamB = 0;
    int cornerTeamB = 0;

    // References to GUI components.
    private Spinner teamA_spinner;
    private ImageView teamA_image;

    private Spinner teamB_spinner;
    private ImageView teamB_image;
    // Animal names
    private final String[] teamA = {"Arsenal", "Crystal Palace", "Hull", "Sunderland", "Tottenham"};
    // Animal image teamAIds
    // Both names and image teamAIds are in the same order
    private final int[] teamAIDs = {R.drawable.arsenal1, R.drawable.crystal_palace,
            R.drawable.hull_city, R.drawable.sunderland1, R.drawable.tottenham1};

    // Animal names
    private final String[] teamB = {"Crystal Palace", "Arsenal", "Hull", "Sunderland", "Tottenham"};
    // Animal image teamAIds
    // Both names and image teamAIds are in the same order
    private final int[] teamBIDs = {R.drawable.crystal_palace, R.drawable.arsenal1,
            R.drawable.hull_city, R.drawable.sunderland1, R.drawable.tottenham1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the GUI components.
        this.teamA_spinner = (Spinner) findViewById(R.id.teamA_spinner);
        this.teamA_image = (ImageView) findViewById(R.id.teamA_image);

        this.teamB_spinner = (Spinner) findViewById(R.id.teamB_spinner);
        this.teamB_image = (ImageView) findViewById(R.id.teamB_image);

        // Create an array adapter and set it to the Spinner.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, teamA);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.teamA_spinner.setAdapter(adapter);

        // Set the message to default.
        this.teamA_spinner.setSelection(0);

        // Set itm selected listener.
        this.teamA_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                teamA_image.setImageResource(teamAIDs[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, teamB);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.teamB_spinner.setAdapter(adapter2);

        // Set the message to default.
        this.teamB_spinner.setSelection(0);

        // Set itm selected listener.
        this.teamB_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                teamB_image.setImageResource(teamBIDs[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
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

    public void goalAdd_TeamA(View view) {
        scoreTeamA += 1;
        displayGoalForTeamA(scoreTeamA);
    }

    public void foulAdd_TeamA(View view) {
        foulTeamA += 1;
        displayFoulForTeamA(foulTeamA);
    }

    public void cornerAdd_TeamA(View view) {
        cornerTeamA += 1;
        displayCornerForTeamA(cornerTeamA);
    }

    public void goalMinus_TeamA(View view) {
        if (scoreTeamA == 0) {
            Toast.makeText(this, "It cannot be less than 0", Toast.LENGTH_SHORT).show();
            return;
        }
        scoreTeamA -= 1;
        displayGoalForTeamA(scoreTeamA);
    }

    public void foulMinus_TeamA(View view) {
        if (foulTeamA == 0) {
            Toast.makeText(this, "It cannot be less than 0", Toast.LENGTH_SHORT).show();
            return;
        }
        foulTeamA -= 1;
        displayFoulForTeamA(foulTeamA);
    }

    public void cornerMinus_TeamA(View view) {
        if (cornerTeamA == 0) {
            Toast.makeText(this, "It cannot be less than 0", Toast.LENGTH_SHORT).show();
            return;
        }
        cornerTeamA -= 1;
        displayCornerForTeamA(cornerTeamA);
    }

    /*For Team B*/
    public void goalAdd_TeamB(View view) {
        scoreTeamB += 1;
        displayGoalForTeamB(scoreTeamB);
    }

    public void foulAdd_TeamB(View view) {
        foulTeamB += 1;
        displayFoulForTeamB(foulTeamB);
    }

    public void cornerAdd_TeamB(View view) {
        cornerTeamB += 1;
        displayCornerForTeamB(cornerTeamB);
    }

    public void goalMinus_TeamB(View view) {
        if (scoreTeamB == 0) {
            Toast.makeText(this, "It cannot be less than 0", Toast.LENGTH_SHORT).show();
            return;
        }
        scoreTeamB -= 1;
        displayGoalForTeamB(scoreTeamB);
    }

    public void foulMinus_TeamB(View view) {
        if (foulTeamB == 0) {
            Toast.makeText(this, "It cannot be less than 0", Toast.LENGTH_SHORT).show();
            return;
        }
        foulTeamB -= 1;
        displayFoulForTeamB(foulTeamB);
    }

    public void cornerMinus_TeamB(View view) {
        if (cornerTeamB == 0) {
            Toast.makeText(this, "It cannot be less than 0", Toast.LENGTH_SHORT).show();
            return;
        }
        cornerTeamB -= 1;
        displayCornerForTeamB(cornerTeamB);
    }

    public void reset(View v) {
        scoreTeamA = 0;
        foulTeamA = 0;
        cornerTeamA = 0;
        displayGoalForTeamA(scoreTeamA);
        displayFoulForTeamA(foulTeamA);
        displayCornerForTeamA(cornerTeamA);

        scoreTeamB = 0;
        foulTeamB = 0;
        cornerTeamB = 0;
        displayGoalForTeamB(scoreTeamB);
        displayFoulForTeamB(foulTeamB);
        displayCornerForTeamB(cornerTeamB);

    }
}
