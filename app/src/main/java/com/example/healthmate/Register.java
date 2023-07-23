package com.example.healthmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    public static final String TAG = "TAG";

    TextView editTextEmail, editTextPassword;
    EditText editTextFirstname, editTextLastname, editTextPhone;

    Button signup;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    ProgressBar progressBar;
    TextView textView;
    String userID;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        editTextFirstname = findViewById(R.id.first_name);
        editTextLastname = findViewById(R.id.last_name);
        editTextPhone = findViewById(R.id.phone);

        progressBar = findViewById(R.id.progressBar);
        signup = findViewById(R.id.btn_signup);
        textView = findViewById(R.id.loginNow);

        if (fAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        textView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sEmail = editTextEmail.getText().toString().trim();
                String sPassword = editTextPassword.getText().toString().trim();

                String sFirstname = editTextFirstname.getText().toString();
                String sLastname = editTextLastname.getText().toString();
                String sPhone= editTextPhone.getText().toString();

                if (sFirstname.isEmpty() || sLastname.isEmpty() || sEmail.isEmpty() || sPassword.isEmpty() || sPhone.isEmpty() )
                {
                    Toast.makeText(Register.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty(sEmail)){
                    editTextEmail.setError("email is required");
                    return;
                }
                if (TextUtils.isEmpty(sPassword)){
                    editTextPassword.setError("password is required");
                    return;
                }

                if (sPassword.length()<6){
                    editTextPassword.setError("Password must be >=6 characters");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(sEmail, sPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                        Toast.makeText(Register.this, "user created", Toast.LENGTH_SHORT).show();
                        userID = fAuth.getCurrentUser().getUid();
                        DocumentReference documentReference = fStore.collection("users").document(userID);
                        Map<String, Object> user = new HashMap<>();
                        user.put("First Name", sFirstname);
                        user.put("Last Name", sLastname);
                        user.put("Email", sEmail);
                        user.put("Password", sPassword);
                        user.put("Phone", sPhone);

                        documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Log.d(TAG, "onSuccess: User profile created for " + userID );
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.d(TAG, "onFailure: " + e.toString() );
                            }
                        });

                        startActivity(new Intent(getApplicationContext(), MainActivity.class));

                    }

                    else{
                        Toast.makeText(Register.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
           }
        });

    }
});
    }}

// if(task.isSuccessful()){
//         Toast.makeText(Register.this, "user created", Toast.LENGTH_SHORT).show();
//         startActivity(new Intent(getApplicationContext(), MainActivity.class));
//        }
//        else{
//        Toast.makeText(Register.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//        progressBar.setVisibility(View.GONE);
//        }