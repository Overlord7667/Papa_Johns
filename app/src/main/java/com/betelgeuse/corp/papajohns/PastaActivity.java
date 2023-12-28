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

import java.util.ArrayList;
import java.util.List;

public class PastaActivity extends AppCompatActivity {
    List<Pasta> AllPasta = new ArrayList<>();
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasta);
        this.setTitle("Pasta");

        intent = getIntent();

        ListView listView = findViewById(R.id.listPasta);
        //        AllPizzas.add(new Pizza("N1", R.drawable.picca));
//        AllPizzas.add(new Pizza("N2", R.drawable.picca));
//        AllPizzas.add(new Pizza("N3", R.drawable.picca));

//        String addPizza = intent.getStringExtra("key");
//        String addPizza1 = intent.getStringExtra("key1");
//        String addPizza2 = intent.getStringExtra("key2");
//        String addPizza3 = intent.getStringExtra("key3");
        Pasta[] AllPastaString = (Pasta[]) intent.getSerializableExtra("pastas");
        if (AllPastaString != null){
            for (int i = 0; i < AllPastaString.length; i++) {
                AllPasta.add(AllPastaString[i]);
            }
        }

        AllPasta.add(new Pasta("Udon", R.drawable.italyanskaya_pasta,"a",1000,2500,3000));
        AllPasta.add(new Pasta("Ramen", R.drawable.italyanskaya_pasta,"b",2000,2500,3000));
        AllPasta.add(new Pasta("Ugor", R.drawable.italyanskaya_pasta,"c",1500,2000,2500));
        AllPasta.add(new Pasta("Chicken", R.drawable.italyanskaya_pasta,"d",2000,3000,3500));
//        ArrayList<String> myList = (ArrayList<String>) intent.getSerializableExtra("myList");
//        // Создайте адаптер для списка:
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myList);
        PastaActivity.PastaAdapter pizzaAdapter = new PastaActivity.PastaAdapter
                (AllPasta, this, R.layout.card_products);
        // Установите адаптер для списка:
        listView.setAdapter(pizzaAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent(PastaActivity.this, ProductSelection.class);
                intent1.putExtra("title1", "PASTA");
                setResult(0,intent1);
                startActivity(intent1);
            }
        });
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
        } else if (id == R.id.stories) {
            Toast.makeText(this, "This is View", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.createorder) {
            Toast.makeText(this, "Order", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    class PastaAdapter extends BaseAdapter {

        List<Pasta> Pastas;
        Context context;
        int TemplateLayout;
        LayoutInflater inflater;

        public PastaAdapter(List<PastaActivity.Pasta> pastas, Context context, int templateLayout) {
            Pastas = pastas;
            this.context = context;
            TemplateLayout = templateLayout;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return Pastas.size();
        }

        @Override
        public Object getItem(int position) {
            return Pastas.get(position);
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
            Pasta pasta = Pastas.get(position);
            name.setText(pasta.getName());
            photo.setImageResource(pasta.getImageId());
            return view;
        }
    }

    class Pasta{
        String Name;
        String Ingredients;
        int Price1;
        int Price2;
        int Price3;
        int ImageId;

        public Pasta(String name, int imageId, String ingredients, int price1, int price2, int price3) {
            Name = name;
            ImageId = imageId;
            Ingredients = ingredients;
            Price1 = price1;
            Price2 = price2;
            Price3 = price3;
        }
        public Pasta(){}
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
}