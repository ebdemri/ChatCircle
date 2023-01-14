package com.example.chatcircle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText emailedittext,passwordedittext;
    Button registerButton;
    Button loginButton;

FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        emailedittext=findViewById(R.id.edittextregisteremail);
        passwordedittext =findViewById(R.id.edittextregisterpassword);
        registerButton=findViewById(R.id.register_registerbutton);

        mAuth=FirebaseAuth.getInstance();

        loginButton.setOnClickListener(v->{
            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
           finish();
        });
registerButton.setOnClickListener(v->{
    String email=emailedittext.getText().toString();
    String password = passwordedittext.getText().toString();

    if(email.isEmpty()||password.isEmpty()){
        Toast.makeText(RegisterActivity.this, "Lütfen tüm alanları doldurun ", Toast.LENGTH_SHORT).show();
        return;
    }


    if(registerButton.length()<6){
        Toast.makeText(RegisterActivity.this, "Şifreniz en az 6 karakter olmalıdır", Toast.LENGTH_SHORT).show();
        return;
    }


   // mAuth.createUserWithEmailAndPassword(email,password).addOnCanceledListener(task->{
       // if(task.isSuccesful()){
            //Toast.makeText(RegisterActivity.this, "İşlem Başarılı", Toast.LENGTH_SHORT).show();
            //startActivity(new Intent(RegisterActivity.this,MainActivity.class));
           // finish();

     //   }else{
       //     Toast.makeText(RegisterActivity.this, "Kayıt Başarısız", Toast.LENGTH_SHORT).show();
     //   }

  //  });


});

    }
}