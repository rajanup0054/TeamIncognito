package com.example.medidoc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PatientLoginActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);

        // Find views by their IDs
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        // Set onClickListener for the login button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to the PatientDashboard activity without credential verification
                Intent intent = new Intent(PatientLoginActivity.this, PatientDashboardActivity.class);
                // Pass the username to the PatientDashboard activity
                intent.putExtra("USERNAME", editTextUsername.getText().toString());
                startActivity(intent);
                finish(); // Close the login activity
            }
        });
    }
}
