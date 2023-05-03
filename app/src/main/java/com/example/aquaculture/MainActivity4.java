package com.example.aquaculture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;



import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    private ArrayList<String> patientName;
    private Button GetResultsButton;
    private DatabaseReference mDatabase;
    private Spinner patientSpinner;
    private ArrayAdapter<String> patientAdapter;
    private String selected_patient;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);





        mDatabase = FirebaseDatabase.getInstance().getReference();
        GetResultsButton = findViewById(R.id.get_results_id);
        patientName = new ArrayList<>();
        patientName.add("---------");
        patientSpinner = findViewById(R.id.patient_name_spinner);


        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                patientName.clear();
                patientName.add("---------");
                for(DataSnapshot ds:dataSnapshot.getChildren()) {
                    patientName.add(ds.getKey());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        patientAdapter = new ArrayAdapter<>(MainActivity4.this,android.R.layout.simple_spinner_dropdown_item,patientName);
        patientSpinner.setAdapter(patientAdapter);

        patientSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_patient = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        GetResultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ValuesIntent = new Intent(MainActivity4.this, ValuesActivity.class);
                ValuesIntent.putExtra("patient_name",selected_patient);
                startActivity(ValuesIntent);
            }
        });


    }





}