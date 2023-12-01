package com.betelgeuse.corp.papajohns;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout pizzas = findViewById(R.id.pizzasID);
        RelativeLayout pastas = findViewById(R.id.pastaID);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void pizzasShow(View view) {
        Toast.makeText(this, "PIZZA", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, PizzaActivity.class);
        this.setTitle("Pizzas");
        startActivity(intent);
    }

    public void pastasShow(View view) {
        Toast.makeText(this, "PASTA", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, PastaActivity.class);
        startActivity(intent);
    }
}