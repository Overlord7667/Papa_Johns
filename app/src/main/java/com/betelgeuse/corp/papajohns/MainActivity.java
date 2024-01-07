package com.betelgeuse.corp.papajohns;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.pizzas){
            Toast.makeText(this, "PIZZA", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, PizzasActivity.class);
            startActivity(intent);
        } else if (id == R.id.pasta) {
            Toast.makeText(this, "PASTA", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, PastaActivity.class);
            startActivity(intent);
        } else if (id == R.id.stores) {
            Toast.makeText(this, "This is View", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.buy) {
            Intent intent = new Intent(this, Orders.class);
            startActivity(intent);
            Toast.makeText(this, "Order", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void pizzasShow(View view) {
        Intent intent = new Intent(this, PizzasActivity.class);
        startActivity(intent);
    }

    public void pastasShow(View view) {
        Intent intent = new Intent(this, PastaActivity.class);
        startActivity(intent);
    }
}