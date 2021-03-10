package com.example.cora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        EditText firstNameEditText;
        EditText lastNameEditText;
        EditText emailEditText;
        EditText passwordEditText;
        Button registerBtn;
        Button loginBtn;

        //boolean used to check fields
        boolean valid = true;


        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        registerBtn = findViewById(R.id.registerBtn);
        loginBtn = findViewById(R.id.loginBtn);

        //call checkField function for each widget
        checkField(firstNameEditText);
        checkField(lastNameEditText);
        checkField(emailEditText);
        checkField(passwordEditText);

    }

    //function to check if text fields are empty
    public boolean checkField(EditText textField)
    {
        if(textField.getText().toString().isEmpty())
        {
            textField.setError("Error");
            valid = false;
        }
        else
        {
            valid = true;
        }
    }

}