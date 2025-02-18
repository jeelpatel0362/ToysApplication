package com.example.toysapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginPage extends AppCompatActivity {

    private EditText etMobileNumber, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);
        etMobileNumber = findViewById(R.id.mobileNumber_content);
        etPassword = findViewById(R.id.password_content);

        findViewById(R.id.loginUpBtn).setOnClickListener(v -> loginUser());

        findViewById(R.id.signUp).setOnClickListener(v -> {
            startActivity(new Intent(this, SignUp.class));
            finish();
        });
    }

    public void loginUser(){
        String mobileNumber = etMobileNumber.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        SharedPreferences prefs = getSharedPreferences("ToysAppsPrefs", MODE_PRIVATE);
        String storedPassword = prefs.getString("password", null);
        String storedMobileNumber = prefs.getString("mobileNumber", null);

        if (TextUtils.isEmpty(mobileNumber) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please fill all details", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!mobileNumber.equals(storedMobileNumber)) {
            etMobileNumber.setError("Invalid Account Number");
            etMobileNumber.requestFocus();
            return;
        } else if (!password.equals(storedPassword)) {
            etPassword.setError("Password does not match.");
            etPassword.requestFocus();
            return;
        } else {

            prefs.edit().putBoolean("isLoggedIn", true).apply();

            String name = prefs.getString("userName", "user");
            UserData userData = new UserData(name,storedMobileNumber);
            Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, HomePage.class);
            intent.putExtra("user", userData);
            startActivity(intent);
            finish();

        }


    }

}