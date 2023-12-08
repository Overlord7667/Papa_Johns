package com.betelgeuse.corp.papajohns;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PizzasActivity extends AppCompatActivity {
    List<Pizza> AllPizzas = new ArrayList<>();
    Intent intent;

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        intent = data;
//
//        if (data != null)
//        {
//            Toast.makeText(this, "NEWPIZZA", Toast.LENGTH_SHORT).show();
////            String addPizza = intent.getStringExtra("key");
////            AllPizzas.add(new Pizza(addPizza, R.drawable.picca));
//        }else {
//            Toast.makeText(this, "NOT DATA", Toast.LENGTH_SHORT).show();
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzas);
        setTitle("Pizzas");

        intent = getIntent();

        ListView listView = findViewById(R.id.listPizzas);
//        AllPizzas.add(new Pizza("N1", R.drawable.picca));
//        AllPizzas.add(new Pizza("N2", R.drawable.picca));
//        AllPizzas.add(new Pizza("N3", R.drawable.picca));

            String addPizza = intent.getStringExtra("key");
            String addPizza1 = intent.getStringExtra("key1");
            String addPizza2 = intent.getStringExtra("key2");
            String addPizza3 = intent.getStringExtra("key3");

            AllPizzas.add(new Pizza(addPizza, R.drawable.picca));
            AllPizzas.add(new Pizza(addPizza1, R.drawable.picca));
            AllPizzas.add(new Pizza(addPizza2, R.drawable.picca));
            AllPizzas.add(new Pizza(addPizza3, R.drawable.picca));


//        ArrayList<String> myList = (ArrayList<String>) intent.getSerializableExtra("myList");
//        // Создайте адаптер для списка:
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myList);

        PizzaAdapter pizzaAdapter = new PizzaAdapter(AllPizzas, this, R.layout.card_products);
        // Установите адаптер для списка:
        listView.setAdapter(pizzaAdapter);
    }

    class PizzaAdapter extends BaseAdapter{

        List<Pizza> Pizzas;
        Context context;
        int TemplateLayout;
        LayoutInflater inflater;

        public PizzaAdapter(List<Pizza> pizzas, Context context, int templateLayout) {
            Pizzas = pizzas;
            this.context = context;
            TemplateLayout = templateLayout;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return Pizzas.size();
        }

        @Override
        public Object getItem(int position) {
            return Pizzas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = inflater.inflate(TemplateLayout, parent, false);
            TextView name = view.findViewById(R.id.text_cardsID);
            ImageView photo = view.findViewById(R.id.imgPizza);
            Pizza pizza = Pizzas.get(position);
            name.setText(pizza.getName());
            photo.setImageResource(pizza.getImageId());
            return view;
        }
    }

    class Pizza{
        String Name;
        int ImageId;

        public Pizza(String name, int imageId) {
            Name = name;
            ImageId = imageId;
        }
        public Pizza(){}

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public int getImageId() {
            return ImageId;
        }

        public void setImageId(int imageId) {
            ImageId = imageId;
        }
    }
}