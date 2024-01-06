package com.betelgeuse.corp.papajohns;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductSelection extends AppCompatActivity {
    Intent intent;
    private TextView textView;
    private TextView textView1;
    private TextView textView2;
    private int counter = 0; // начальное значение
    private ImageView pizzasImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_selection);
        intent = getIntent();

        String title = intent.getStringExtra("title1");
        setTitle(title);

        Spinner spinner = findViewById(R.id.productSize);
        textView = findViewById(R.id.valueProduct);
        textView1 = findViewById(R.id.nameProduct);
        textView2 = findViewById(R.id.ingredients);
        Button plusButton = findViewById(R.id.plusButton);
        Button minusButton = findViewById(R.id.minusButton);
        pizzasImageView = findViewById(R.id.pizzasID);

        String[] values = {"120 Cm", "180 Cm", "240 Cm"};

        // Создаем адаптер для Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, values);

        // Устанавливаем стиль выпадающего списка
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Устанавливаем адаптер для Spinner
        spinner.setAdapter(adapter);

        // Устанавливаем обработчик выбора элемента в Spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Выполняется при выборе элемента
                String selectedValue = values[position];
                Toast.makeText(ProductSelection.this, "Выбрано: " + selectedValue, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Выполняется, если ничего не выбрано
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Увеличение значения на 1 и обновление TextView
                counter++;
                updateCounter();
            }
        });

        // Установка слушателя для кнопки "-"
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Уменьшение значения на 1, но не менее 0, и обновление TextView
                counter = Math.max(0, counter - 1);
                updateCounter();
            }
        });

        if (intent != null && intent.hasExtra("selectedPizza")) {
            Pizza selectedPizza = (Pizza) intent.getSerializableExtra("selectedPizza");
            // Теперь у вас есть объект selectedPizza с данными о выбранной пицце
            // Далее можете использовать эти данные в вашей новой активности
            Toast.makeText(this, "Danie peredalis", Toast.LENGTH_SHORT).show();
            // Устанавливаем изображение пиццы в ImageView
            pizzasImageView.setImageResource(selectedPizza.getImageId());
            textView1.setText(selectedPizza.getName());
            textView2.setText(selectedPizza.getIngredients());
        }
    }
    // Обновление TextView с текущим значением
    private void updateCounter() {
        textView.setText(String.valueOf(counter));
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
            Intent intent = new Intent(this, PastaActivity.class);
            startActivity(intent);
            Toast.makeText(this, "PASTA", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.stories) {
            Toast.makeText(this, "This is View", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.createorder) {
            Toast.makeText(this, "Order", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}