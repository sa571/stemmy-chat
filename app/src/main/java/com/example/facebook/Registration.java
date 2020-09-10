package com.example.facebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {
 EditText email, surname, phone, password;
 String Email, Surname, Phone, Password;
 Button register, clear, registered;
private FirebaseAuth firebaseAuth;
private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        firebaseAuth=FirebaseAuth.getInstance();


        register=findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        clear=findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        registered=findViewById(R.id.registered);
        registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init();
                validate();

            }
        });





    }

  public void init()  {
  email=findViewById(R.id.email) ;
  surname=findViewById(R.id.surname);
  phone=findViewById(R.id.phone);
  password=findViewById(R.id.password);
  Email=email.getText().toString().trim();
  Surname=surname.getText().toString().trim();
  Phone=phone.getText().toString().trim();
  Password=password.toString().trim();

  }
  public void validate(){
   if(Email.isEmpty()) {
    email.setError("last warning");
   }else if(Surname.isEmpty()){
       surname.setError("last warning");
   }else if (Phone.isEmpty()){
       phone.setError("get out");
   }else if(Password.isEmpty()){
       password.setError("respect your old age");

   }else{
       firebaseAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(Registration.this, new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {
               Toast.makeText(Registration.this,"createUserWithEmail:onComplete"+task.isSuccessful(), Toast.LENGTH_LONG).show();
             if(!task.isSuccessful()) {
                 Toast.makeText(Registration.this,"Authentication failed"+task.getException(),Toast.LENGTH_LONG).show();
             }else {
                 FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
                 DatabaseReference  databaseReference=firebaseDatabase.getReference().child("user").push();
                 FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
                 String userid=firebaseUser.getUid();
                 databaseReference.child("Email").setValue(Email);
                 databaseReference.child("Full name").setValue(surname);
               databaseReference.child("Password").setValue(Password);
               databaseReference.child("userid").setValue(userid);
                 Intent intent =new Intent(Registration.this,MainActivity.class);
                 startActivity(intent);
                 finish();

           }
       }


           });
       }}}






