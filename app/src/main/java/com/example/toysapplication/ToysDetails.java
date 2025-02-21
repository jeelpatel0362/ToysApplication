package com.example.toysapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ToysDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_toys_details);

        findViewById(R.id.BackButton).setOnClickListener(v -> {
            startActivity(new Intent(this, HomePage.class));
        });

        String toys_name = getIntent().getStringExtra("toys_name");
        String toys_price = getIntent().getStringExtra("toys_price");
        int toys_image = getIntent().getIntExtra("toys_image", 0);

        TextView toysName = findViewById(R.id.toysName);
        TextView toysPrice = findViewById(R.id.toysPrice);
        ImageView toysImage = findViewById(R.id.toysImage);

        toysName.setText(toys_name);
        toysPrice.setText(toys_price);
        toysImage.setImageResource(toys_image);

        findViewById(R.id.addCart).setOnClickListener(v -> {

            Toast.makeText(this, "Added to Cart", Toast.LENGTH_SHORT).show();

        });


    }
}