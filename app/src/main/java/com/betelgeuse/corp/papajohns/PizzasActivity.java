package com.betelgeuse.corp.papajohns;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PizzasActivity extends AppCompatActivity {
    List<Pizza> AllPizzas = new ArrayList<>();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzas);
        setTitle("Pizzas");

        intent = getIntent();
        ListView listView = findViewById(R.id.listPizzas);

        Pizza[] AllPizzasString = (Pizza[]) intent.getSerializableExtra("pizzas");
        if (AllPizzasString != null){
            for (int i = 0; i < AllPizzasString.length; i++) {
                AllPizzas.add(AllPizzasString[i]);
        }
        }
            AllPizzas.add(new Pizza("Italian",R.drawable.picca, "vetchina", 2001, 2002, 2003));
            AllPizzas.add(new Pizza("Marcipano", R.drawable.picca, "luk", 2001, 2002, 2003));
            AllPizzas.add(new Pizza("Lachetti", R.drawable.picca, "ananas", 2001, 2002, 2003));
            AllPizzas.add(new Pizza("Peperoni", R.drawable.picca, "peperoni", 21, 22, 23));

        // Создайте адаптер для списка:
        PizzaAdapter pizzaAdapter = new PizzaAdapter(AllPizzas, this, R.layout.card_products);
        // Установите адаптер для списка:
        listView.setAdapter(pizzaAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Получаем выбранный элемент из списка
                Pizza selectedPizza = (Pizza) parent.getItemAtPosition(position);
                Intent intent1 = new Intent(PizzasActivity.this, ProductSelection.class);
                intent1.putExtra("title1", "PIZZA");
                // Передаем объект Pizza в новую активность
                intent1.putExtra("selectedPizza", selectedPizza);
                setResult(0,intent1);
                startActivity(intent1);
            }
        });
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
        } else if (id == R.id.pasta) {
            Intent intent = new Intent(this, PastaActivity.class);
            startActivity(intent);
            Toast.makeText(this, "PASTA", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.stores) {
            Toast.makeText(this, "This is View", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.buy) {
            Intent intent = new Intent(this, Orders.class);
            startActivity(intent);
            Toast.makeText(this, "Order", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
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
}

class Pizza implements Serializable {
    String Name;
    String Ingredients;
    int Price1;
    int Price2;
    int Price3;
    int ImageId;

    public Pizza(String name, int imageId, String ingredients, int price1, int price2, int price3) {
        Name = name;
        ImageId = imageId;
        Ingredients = ingredients;
        Price1 = price1;
        Price2 = price2;
        Price3 = price3;
    }
    public Pizza(){}

    public String getIngredients() {
        return Ingredients;
    }

    public void setIngredients(String ingredients) {
        Ingredients = ingredients;
    }

    public int getPrice1() {
        return Price1;
    }
    public void setPrice1(int price1) {
        Price1 = price1;
    }

    public int getPrice2() {
        return Price2;
    }
    public void setPrice2(int price2) {
        Price2 = price2;
    }

    public int getPrice3() {
        return Price3;
    }
    public void setPrice3(int price3) {
        Price3 = price3;
    }

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