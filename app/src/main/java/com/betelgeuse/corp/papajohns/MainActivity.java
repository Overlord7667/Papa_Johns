package com.betelgeuse.corp.papajohns;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//    ArrayList<String> AllPizz = new ArrayList<>();
//    ArrayList<String> AllPasta = new ArrayList<>();

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
//        RelativeLayout relativeLayout = findViewById(R.id.firstActivity);
        if (id == R.id.pizzas){
            Toast.makeText(this, "PIZZA", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, PizzasActivity.class);
            startActivity(intent);
        } else if (id == R.id.pasta) {
            Toast.makeText(this, "PASTA", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, PastaActivity.class);
            startActivity(intent);
        } else if (id == R.id.stories) {
            Toast.makeText(this, "This is View", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.createorder) {
            Toast.makeText(this, "Order", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void pizzasShow(View view) {
        Intent intent = new Intent(this, PizzasActivity.class);
//        String[] date;
//        Pizza[] pizzas = {
//                new Pizza("с тестом", R.drawable.picca, "salyami", "54 sm", 2, 2500),
//                new Pizza("с ветчиной", R.drawable.italyanskaya_pasta, "salyami", "54 sm", 2, 3500),
//                new Pizza("с беконом", R.drawable.picca, "salyami", "54 sm", 2, 1500),
//                new Pizza("с сыром", R.drawable.picca, "salyami", "54 sm", 2, 2000),
//                new Pizza("с грибами", R.drawable.picca, "salyami", "54 sm", 2, 4000)
//        };
//        date = AllPizz.toArray(new String[0]);
//        intent.putExtra("pizzas", pizzas);
//        intent.putExtra("title", "PIZZA");
//        setResult(0,intent);
        startActivity(intent);
    }


    public void pastasShow(View view) {
        Intent intent = new Intent(this, PastaActivity.class);
//        intent.putExtra("key", AllPasta.get(0));
//        intent.putExtra("key1", AllPasta.get(1));
//        intent.putExtra("key2", AllPasta.get(2));
//        intent.putExtra("key3", AllPasta.get(3));
//        setResult(1,intent);
        startActivity(intent);
    }
}