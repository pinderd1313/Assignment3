package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.ArraySet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VotingActivity extends AppCompatActivity {
    private Spinner spinner;
    ToggleButton toggleButton;
    Button button;
    EditText inputName, inputId;
    private ArrayList<Candidate> candidateList;
    ArrayList<Voter> voters;
    private boolean accepted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);

        voters = new ArrayList<Voter>();
        spinner = findViewById(R.id.spinner);
        toggleButton = findViewById(R.id.toggleButton);
        button = findViewById(R.id.button);
        inputName = findViewById(R.id.editTextTextPersonName);
        inputId = findViewById(R.id.editTextTextPersonID);


        Intent intent = getIntent();
        ArrayList<Candidate> candidates = (ArrayList<Candidate>) intent.getSerializableExtra("candidates");
        candidateList = candidates;

        ArrayAdapter<Candidate> adapter = new ArrayAdapter<Candidate>(this,
                android.R.layout.simple_spinner_item, candidateList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputName.getText().toString().isEmpty()){
                    Toast.makeText(VotingActivity.this, "Please fill the name field", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(inputId.getText().toString().isEmpty()){
                    Toast.makeText(VotingActivity.this, "Please fill the Id field", Toast.LENGTH_SHORT).show();
                    return;
                }

                for (Voter V : voters) {
                    if(V.getId() == Integer.parseInt(inputId.getText().toString())){
                        Toast.makeText(VotingActivity.this, "Opps!! Id already present", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                
                if(!toggleButton.isChecked()){
                    Toast.makeText(VotingActivity.this, "Please accept the terms and condition first", Toast.LENGTH_SHORT).show();
                    return;
                }

                voters.add(new Voter(Integer.parseInt(inputId.getText().toString()), inputName.getText().toString()));
                int selectedCandidateIndex = spinner.getSelectedItemPosition();
                Candidate selectedCandidate = candidateList.get(selectedCandidateIndex);
                selectedCandidate.setVotes(selectedCandidate.getVotes() + 1);

                Toast.makeText(VotingActivity.this, "Your vote has been casted !!", Toast.LENGTH_SHORT).show();


            }
        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {

                    toggleButton.setTextOn("Refuse");

                } else {

                    toggleButton.setTextOff("Accept");
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
       Intent intent = new Intent(VotingActivity.this, MainActivity.class);
       intent.putExtra("candidates", candidateList);
       startActivity(intent);
    }
}