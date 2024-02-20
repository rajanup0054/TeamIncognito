package com.example.medidoc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PatientDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_dashboard);

        // Retrieve the TextView
        TextView textViewWelcome = findViewById(R.id.textViewWelcome);

        // Get the username from the intent
        String username = getIntent().getStringExtra("USERNAME");

        // Set the welcome message
        if (username != null && !username.isEmpty()) {
            textViewWelcome.setText("Hello, " + username + "!");
        }
    }
}