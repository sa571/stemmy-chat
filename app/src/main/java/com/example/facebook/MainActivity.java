package com.example.facebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
EditText email,pass;
String Email,Pass;
Button login;
private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseAuth=FirebaseAuth.getInstance();
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
        }else{firebaseAuth.signInWithEmailAndPassword(Email,Pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Toast.makeText(MainActivity.this,"createUserWithEmail:onComplete"+task.isSuccessful(),Toast.LENGTH_LONG).show();
                if (!task.isSuccessful()) {
                    Toast.makeText(MainActivity.this,"Authentication failed"+task.getException(),Toast.LENGTH_LONG).show();
                }
                }
            });
        };


    }

        }

