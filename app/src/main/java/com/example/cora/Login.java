package com.example.cora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {


    EditText emailLogin,passwordLogin;
    Button registerLogin,loginLogin;
    boolean valid = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        emailLogin = findViewById(R.id.emailLogin);
        passwordLogin = findViewById(R.id.passwordLogin);
        registerLogin = findViewById(R.id.registerLogin);
        loginLogin = findViewById(R.id.loginLogin);

        checkField(emailLogin);
        checkField(passwordLogin);

        //if register button is clicked then redirect to register page
        registerLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });
    }


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

        return valid;
    }

}