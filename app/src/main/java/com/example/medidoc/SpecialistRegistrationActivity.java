package com.example.medidoc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SpecialistRegistrationActivity extends AppCompatActivity {

    private EditText editTextFullName, editTextAge, editTextEmail, editTextExperience;
    private RadioGroup radioGroupType;
    private Button buttonUploadLicenses, buttonSubmit;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialist_registration);

        // Initialize Firebase
        databaseReference = FirebaseDatabase.getInstance().getReference().child("specialists");

        // Find views by their IDs
        editTextFullName = findViewById(R.id.editTextFullName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextExperience = findViewById(R.id.editTextExperience);
        radioGroupType = findViewById(R.id.radioGroupSpecialistType);
        buttonUploadLicenses = findViewById(R.id.buttonUploadLicenses);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Set onClickListener for the upload licenses button
        buttonUploadLicenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add logic for uploading licenses (PDF)
                // You can use libraries like Firebase Storage for file uploads
                // Example: Upload licenses to Firebase Storage and store the download link in Firebase Database
                // Update the code accordingly based on your file upload implementation
            }
        });

        // Set onClickListener for the submit button
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get values from the user input
                String fullName = editTextFullName.getText().toString().trim();
                String ageStr = editTextAge.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String experienceStr = editTextExperience.getText().toString().trim();

                // Validate input
                if (fullName.isEmpty() || ageStr.isEmpty() || email.isEmpty() || experienceStr.isEmpty()) {
                    Toast.makeText(SpecialistRegistrationActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Get selected radio button type
                int selectedId = radioGroupType.getCheckedRadioButtonId();
                RadioButton radioButtonType = findViewById(selectedId);
                String type = radioButtonType.getText().toString();

                // Parse age and experience to integers
                int age = Integer.parseInt(ageStr);
                int experience = Integer.parseInt(experienceStr);

                // Create Specialist object
                Specialist specialist = new Specialist(type, fullName, age, email, experience);

                // Push data to Firebase
                DatabaseReference newSpecialistRef = databaseReference.push();
                newSpecialistRef.setValue(specialist);

                // Show success message
                Toast.makeText(SpecialistRegistrationActivity.this, "Specialist information submitted successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
