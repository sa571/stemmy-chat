package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText email,pass;
String Email,Pass;
Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
login=findViewById(R.id.login);
login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
init();
validate();
    }
});


    }
    public void init(){
    email=findViewById(R.id.email) ;
    pass=findViewById(R.id.pass);
    Email=email.getText().toString().trim();
    Pass=pass.getText().toString().trim();


    }public void validate(){
        if (Email.isEmpty()) {
            email.setError("please try again later");
        } else if (Pass.isEmpty()) {
            pass.setError("please your pin again");
        }


    }

        }

