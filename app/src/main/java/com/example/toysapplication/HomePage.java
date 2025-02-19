package com.example.toysapplication;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);

        GridView gridView = findViewById(R.id.gridView);

        List<ProductList> productList = new ArrayList<>();

        productList.add(new ProductList("Toy Bus", "600 ₹", R.drawable.bus));
        productList.add(new ProductList("Buzz Lightyear", "350 ₹", R.drawable.buzz));
        productList.add(new ProductList("Car", "400 ₹", R.drawable.car));
        productList.add(new ProductList("Duck", "200 ₹", R.drawable.duck));
        productList.add(new ProductList("Toy Plane", "350 ₹", R.drawable.plane));
        productList.add(new ProductList("Legos", "300 ₹", R.drawable.lego));
        productList.add(new ProductList("Minion", "100 ₹", R.drawable.minion));
        productList.add(new ProductList("Multicolor Stacking", "250 ₹", R.drawable.multicolor_stacking));
        productList.add(new ProductList("Rabbit Teddy", "220 ₹", R.drawable.rabbit));

        CustomAdaptor adapter = new CustomAdaptor(this, productList);
        gridView.setAdapter(adapter);

        findViewById(R.id.BackButton).setOnClickListener(v -> {
            finish();
        });

    }
}