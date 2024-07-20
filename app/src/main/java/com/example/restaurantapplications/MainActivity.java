package com.example.restaurantapplications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPerlis = findViewById(R.id.btnPerlis);
        Button btnSelangor = findViewById(R.id.btnSelangor);
        Button btnJohor = findViewById(R.id.btnJohor);
        Button btnSabah = findViewById(R.id.btnSabah);
        Button btnAbout = findViewById(R.id.btnAbout);

        btnPerlis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSubCategory("Perlis");
            }
        });

        btnSelangor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSubCategory("Selangor");
            }
        });

        btnJohor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSubCategory("Johor");
            }
        });

        btnSabah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSubCategory("Sabah");
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(aboutIntent);
            }
        });
    }

    void openSubCategory(String cat) {
        Intent i = new Intent(MainActivity.this, RestaurantActivity.class);
        i.putExtra("cat", cat);
        startActivity(i);
    }
}
