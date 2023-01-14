package com.example.chatcircle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText emailedittext,passwordedittext;
    Button loginButton;
    Button registerButton;

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailedittext=findViewById(R.id.edittextloginemail);
        passwordedittext =findViewById(R.id.edittextloginpassword);
        loginButton=findViewById(R.id.login_loginbutton);
        registerButton=findViewById(R.id.login_registerbutton);

        mAuth=FirebaseAuth.getInstance();

        registerButton.setOnClickListener(v->{
            startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            finish();
        });
        loginButton.setOnClickListener(v->{
            String email=emailedittext.getText().toString();
            String password = passwordedittext.getText().toString();

            if(email.isEmpty()||password.isEmpty()){
                Toast.makeText(LoginActivity.this, "Lütfen tüm alanları doldurun ", Toast.LENGTH_SHORT).show();
                return;
            }
           // mAuth.createUserWithEmailAndPassword(email,password).addOnCanceledListener(task->{
               // if(task.isSuccesful()){
                  //  Toast.makeText(LoginActivity.this, "İşlem Başarılı", Toast.LENGTH_SHORT).show();
                   // startActivity(new Intent(LoginActivity.this,MainActivity.class));
                  //  finish();

               // }else{
                //    Toast.makeText(LoginActivity.this, "Kayıt Başarısız", Toast.LENGTH_SHORT).show();
              //  }

          //  });


        });

    }
}