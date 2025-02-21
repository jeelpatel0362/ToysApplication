package com.example.toysapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {

    private ImageView favourite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);

        GridView gridView = findViewById(R.id.gridView);

        List<ProductList> productList = new ArrayList<>();

        productList.add(new ProductList("Toy Bus", "600 ₹", R.drawable.bus,false));
        productList.add(new ProductList("Car", "400 ₹", R.drawable.car,false));
        productList.add(new ProductList("Duck", "200 ₹", R.drawable.duck,false));
        productList.add(new ProductList("Toy Plane", "350 ₹", R.drawable.plane,false));
        productList.add(new ProductList("Legos", "300 ₹", R.drawable.lego,false));
        productList.add(new ProductList("Minion", "100 ₹", R.drawable.minion,false));
        productList.add(new ProductList("Multicolor Stacking", "250 ₹", R.drawable.multicolor_stacking,false));
        productList.add(new ProductList("Rabbit Teddy", "220 ₹", R.drawable.rabbit,false));

        CustomAdaptor adapter = new CustomAdaptor(this, productList);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(HomePage.this, ToysDetails.class);
                intent.putExtra("toys_name", productList.get(position).getName());
                intent.putExtra("toys_price", productList.get(position).getPrice());
                intent.putExtra("toys_image", productList.get(position).getImageResId());
                startActivity(intent);

            }
        });



        findViewById(R.id.BackButton).setOnClickListener(v -> {
            finish();
        });

    }
}