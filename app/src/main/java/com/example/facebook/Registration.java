package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
 EditText email, surname, phone, password;
 String Email, Surname, Phone, Password;
 Button register, clear, registered;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
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
       Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();
   }


  }


}