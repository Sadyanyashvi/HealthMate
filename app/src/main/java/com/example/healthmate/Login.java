package com.example.healthmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    TextView editTextEmail, editTextPassword;
    Button buttonLogin;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    TextView textView;


//    @Override
//    public void onStart() {
//        super.onStart();
//        FirebaseUser currentUser = fAuth.getCurrentUser();
//        if(currentUser != null){
//            Intent intent = new Intent(getApplicationContext(), Login.class);
//            startActivity(intent);
//            finish();
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);

        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);
        buttonLogin = findViewById(R.id.btn_login);
        textView = findViewById(R.id.registerNow);

        textView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
               startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    editTextEmail.setError("email is required");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    editTextPassword.setError("password is required");
                    return;
                }

                if (password.length()<8){
                    editTextPassword.setError("Password must be >=8 characters");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                        else{
                            Toast.makeText(Login.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });
    }
}