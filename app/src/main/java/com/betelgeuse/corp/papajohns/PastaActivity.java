package com.betelgeuse.corp.papajohns;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        String addPizza = intent.getStringExtra("key");
        String addPizza1 = intent.getStringExtra("key1");
        String addPizza2 = intent.getStringExtra("key2");
        String addPizza3 = intent.getStringExtra("key3");
        AllPasta.add(new PastaActivity.Pasta(addPizza, R.drawable.italyanskaya_pasta));
        AllPasta.add(new PastaActivity.Pasta(addPizza1, R.drawable.italyanskaya_pasta));
        AllPasta.add(new PastaActivity.Pasta(addPizza2, R.drawable.italyanskaya_pasta));
        AllPasta.add(new PastaActivity.Pasta(addPizza3, R.drawable.italyanskaya_pasta));


//        ArrayList<String> myList = (ArrayList<String>) intent.getSerializableExtra("myList");
//        // Создайте адаптер для списка:
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myList);

        PastaActivity.PastaAdapter pizzaAdapter = new PastaActivity.PastaAdapter(AllPasta, this, R.layout.card_products);
        // Установите адаптер для списка:
        listView.setAdapter(pizzaAdapter);

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
        int ImageId;

        public Pasta(String name, int imageId) {
            Name = name;
            ImageId = imageId;
        }
        public Pasta(){}

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