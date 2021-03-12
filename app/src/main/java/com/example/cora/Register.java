package com.example.cora;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.ConnectionService;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    //widget variables
    EditText firstNameEditText;
    EditText lastNameEditText;
    EditText emailEditText;
    EditText passwordEditText;
    Button registerBtn;
    Button loginBtn;

    //boolean used to check fields
    boolean valid = true;

    //for firebase authentication
    FirebaseAuth fAuth;

    //for firebase authentication database store
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        registerBtn = findViewById(R.id.registerBtn);
        loginBtn = findViewById(R.id.loginBtn);

        //implement later
        //when register button is clicked, do the stuff insisde
        registerBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //call checkField function for each widget
                checkField(firstNameEditText);
                checkField(lastNameEditText);
                checkField(emailEditText);
                checkField(passwordEditText);

                //if user input text is not blank
                //start initialize user registration
                if(valid)
                {
                    //initialize registration
                    fAuth.createUserWithEmailAndPassword(emailEditText.getText().toString(),passwordEditText.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>()
                    {
                        //this method is triggered when account is created successfully
                        @Override
                        public void onSuccess(AuthResult authResult)
                        {
                            //if registration is successful, firebase auto creates unique user ID
                            //get info of new user that was just created
                            FirebaseUser user = fAuth.getCurrentUser();

                            Toast.makeText(Register.this, "Account Created", Toast.LENGTH_SHORT).show();

                            //used get user ID of newly registered user
                            DocumentReference df = fStore.collection("Users").document(user.getUid());

                            //create map to store user info and upload to firebase
                            Map<String,Object> userInfo = new HashMap<>();
                            userInfo.put("FirstName", firstNameEditText.getText().toString());
                            userInfo.put("LastName", lastNameEditText.getText().toString());
                            userInfo.put("UserEmail", emailEditText.getText().toString());
                            userInfo.put("UserPassword", passwordEditText.getText().toString());

                            //determine if user is admin or regular
                            userInfo.put("isUser", "1");

                            //upload map to firebase
                            df.set(userInfo);

                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener()
                    {
                        @Override
                        public void onFailure(@NonNull Exception e)
                        {
                            Toast.makeText(Register.this, "Failed to Create Account", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }
        });



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

        return valid;
    }

}