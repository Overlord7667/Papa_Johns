package com.betelgeuse.corp.papajohns;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> myList = new ArrayList<>();
    ArrayList<String> AllPizz = new ArrayList<>();
    ArrayList<String> AllPasta = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myList.add("Элемент1");
        myList.add("Элемент2");
        myList.add("Элемент3");

        AllPizz.add(("Пицца с пиццей"));
        AllPizz.add(("Пицца с тестом"));
        AllPizz.add(("Пицца с фигом"));
        AllPizz.add(("Пицца с чем-то"));

        AllPasta.add(("Паста с пастой"));
        AllPasta.add(("Паста с лапшой"));
        AllPasta.add(("Лапша с пастой"));
        AllPasta.add(("Паста с ушей"));

//        if (AllPizz != null) {
//            String text = AllPizz.toString();
//            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
//            // Дальнейшая обработка текста
//        } else {
//            // Обработка ошибки или сообщение пользователю
//            Toast.makeText(this, "DAVAI PO NOVOJ", Toast.LENGTH_SHORT).show();
//        }
    }

    public void pizzasShow(View view) {
        Intent intent = new Intent(this, PizzasActivity.class);
        intent.putExtra("key", AllPizz.get(0));
        intent.putExtra("key1", AllPizz.get(1));
        intent.putExtra("key2", AllPizz.get(2));
        intent.putExtra("key3", AllPizz.get(3));
        intent.putExtra("title", getTitle());
        setResult(0,intent);
        startActivity(intent);
    }



    public void pastasShow(View view) {
        Intent intent = new Intent(this, PastaActivity.class);
        intent.putExtra("key", AllPasta.get(0));
        intent.putExtra("key1", AllPasta.get(1));
        intent.putExtra("key2", AllPasta.get(2));
        intent.putExtra("key3", AllPasta.get(3));
        setResult(1,intent);
        startActivity(intent);
    }
}