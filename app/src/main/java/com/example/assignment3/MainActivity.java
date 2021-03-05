package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Candidate> candidateList;
    private TextView txtViewCandidate1, txtViewCandidate2, txtViewCandidate3;
    private Button btnNavigate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtViewCandidate1 = findViewById(R.id.txtViewCandidate1);
        txtViewCandidate2 = findViewById(R.id.txtViewCandidate2);
        txtViewCandidate3 = findViewById(R.id.txtViewCandidate3);

        btnNavigate = findViewById(R.id.btnNavVote);

        candidateList = new ArrayList<Candidate>();
        Intent intent = getIntent();

        ArrayList<Candidate> candidates = (ArrayList<Candidate>) intent.getSerializableExtra("candidates");
        if(candidates == null){
            candidateList.add(new Candidate(1,"Harwinder",0));
            candidateList.add(new Candidate(2,"Singh",0));
            candidateList.add(new Candidate(3,"Dhaliwal",0));
        }
        else{
            candidateList = candidates;
        }

        txtViewCandidate1.setText(candidateList.get(0).getName()+" : " + candidateList.get(0).getVotes());
        txtViewCandidate2.setText(candidateList.get(1).getName()+" : " + candidateList.get(1).getVotes());
        txtViewCandidate3.setText(candidateList.get(2).getName()+" : " + candidateList.get(2).getVotes());

            btnNavigate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, VotingActivity.class);
                    intent.putExtra("candidates", candidateList);
                    startActivity(intent);
                }
            });


    }
}