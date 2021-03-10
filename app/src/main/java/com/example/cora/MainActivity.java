package com.example.cora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        //Button =  button data type
        //addBtn is variable name (same name as id from xml for convention)
        //(Button) cast result as Button type
        //findViewById is used to locate id from xml
        Button addBtn = (Button) findViewById(R.id.addBtn);

        //anytime addBtn is click do this
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            //this line creates on click event
            public void onClick(View view) {
                EditText firstNameText = (EditText) findViewById(R.id.firstNameText);
                EditText lastNameText = (EditText) findViewById((R.id.lastNameText));
                TextView resultTextView = (TextView) findViewById(R.id.resultTextView);

                String firstName = firstNameText.getText().toString();
                String lastName = lastNameText.getText().toString();

                //display in
                resultTextView.setText(firstName + " " + lastName);
            }
        });

         */
    }
}