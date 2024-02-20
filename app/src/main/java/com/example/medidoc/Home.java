package com.example.medidoc;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Find views by their IDs
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        TextView textViewPatientLogin = findViewById(R.id.textViewPatientLogin);
        // Specialist registration TextView click listener
        TextView textViewSpecialistRegister = findViewById(R.id.textViewSpecialistRegister);
        textViewSpecialistRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to specialist registration
                Intent intent = new Intent(Home.this, SpecialistRegistrationActivity.class);
                startActivity(intent);
            }
        });
        textViewPatientLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to Patient Login activity
                Intent intent = new Intent(Home.this, PatientLoginActivity.class);
                startActivity(intent);
            }
        });

        // Set onClickListener for the login button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check the credentials (example: username: "admin", password: "password")
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                if (username.equals("admin") && password.equals("password")) {
                    // If the credentials are correct, navigate to the next activity or perform other actions
                    // For now, let's go to a placeholder activity (MainActivity)
                    Intent intent = new Intent(Home.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Close the login activity
                } else {
                    // If credentials are incorrect, you may display an error message or take other actions
                    // For now, just display a Toast message
                    Toast.makeText(Home.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
