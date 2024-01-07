package com.betelgeuse.corp.papajohns;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class ProductSelection extends AppCompatActivity {
    Intent intent;
    private TextView textView;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private int counter = 1; // начальное значение
    int initialPrice;
    private ImageView pizzasImageView;
    private Button addBtn;
    private String selectedValue;
    private Pizza selectedPizza;

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
        textView3 = findViewById(R.id.productPrice);
        Button plusButton = findViewById(R.id.plusButton);
        Button minusButton = findViewById(R.id.minusButton);
        pizzasImageView = findViewById(R.id.pizzasID);
        addBtn = findViewById(R.id.addBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationDialog();
            }
        });

        // Вызов метода для обновления TextView
        updateCounter();

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Увеличение значения на 1 и обновление TextView
                counter++;
                updateCounter();

                // Увеличение Price на заданное значение (например, Price1)
                updatePrice(initialPrice);
            }
        });

        // Установка слушателя для кнопки "-"
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Уменьшение значения на 1, но не менее 0, и обновление TextView
                counter = Math.max(1, counter - 1);
                updateCounter();

                // Уменьшение Price, но не менее изначального значения
                updatePrice(initialPrice);
            }
        });

        if (intent != null && intent.hasExtra("selectedPizza")) {
            selectedPizza = (Pizza) intent.getSerializableExtra("selectedPizza");
            // Теперь у вас есть объект selectedPizza с данными о выбранной пицце
            // Далее можете использовать эти данные в вашей новой активности
            // Устанавливаем изображение пиццы в ImageView
            pizzasImageView.setImageResource(selectedPizza.getImageId());
            textView1.setText(selectedPizza.getName());
            textView2.setText(selectedPizza.getIngredients());

            // Здесь можно использовать HashMap для сопоставления строк и цен
            String[] values = {"Small, 120 Cm", "Medium, 180 Cm", "Large, 240 Cm"};

            // Устанавливаем обработчик выбора элемента в Spinner
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                    // Выполняется при выборе элемента
                    selectedValue = values[position];
                    Toast.makeText(ProductSelection.this, "Выбрано: " + selectedValue, Toast.LENGTH_SHORT).show();
//                    int selectedPrice = -1;
                    // Пробегаем по каждому элементу values и сравниваем с selectedValue
                    for (String value : values) {
                        if (selectedValue.equals(value)) {
                            switch (value) {
                                case "Small, 120 Cm":
                                    initialPrice = selectedPizza.getPrice1();
//                                    Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                                    break;
                                case "Medium, 180 Cm":
                                    initialPrice = selectedPizza.getPrice2();
//                                    Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                                    break;
                                case "Large, 240 Cm":
                                    initialPrice = selectedPizza.getPrice3();
//                                    Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                            // Сбрасываем counter на 1 при изменении значения
                            counter = 1;

                            // Обновляем TextView для counter
                            updateCounter();
                        }

                    }

                    // Устанавливаем соответствующий Price в TextView
                    if (initialPrice != -1) {
                        textView3.setText("" + initialPrice);
                    } else {
                        Log.d("MyApp", "Invalid selection: " + selectedValue);
                        textView3.setText("Invalid selection");
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) {
                    // Выполняется, если ничего не выбрано
                }
            });
            // Создаем адаптер для Spinner
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, values);
            // Устанавливаем адаптер для Spinner
            spinner.setAdapter(adapter);

            // Устанавливаем стиль выпадающего списка
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        }
        if (intent != null && intent.hasExtra("selectedPasta")) {
            Pasta selectedPasta = (Pasta) intent.getSerializableExtra("selectedPasta");
            // Теперь у вас есть объект selectedPizza с данными о выбранной пицце
            // Далее можете использовать эти данные в вашей новой активности
            // Устанавливаем изображение пиццы в ImageView
            pizzasImageView.setImageResource(selectedPasta.getImageId());
            textView1.setText(selectedPasta.getName());
            textView2.setText(selectedPasta.getIngredients());

            // Здесь можно использовать HashMap для сопоставления строк и цен
            String[] values = {"Small, 200 Ml", "Medium, 350 Ml", "Large, 500 Ml"};

            // Устанавливаем обработчик выбора элемента в Spinner
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                    // Выполняется при выборе элемента
                    String selectedValue = values[position];
                    Toast.makeText(ProductSelection.this, "Выбрано: " + selectedValue, Toast.LENGTH_SHORT).show();

//                    int selectedPrice = -1;
                    // Пробегаем по каждому элементу values и сравниваем с selectedValue
                    for (String value : values) {
                        if (selectedValue.equals(value)) {
                            switch (value) {
                                case "Small, 200 Ml":
                                    initialPrice = selectedPasta.getPrice1();
//                                    Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                                    break;
                                case "Medium, 350 Ml":
                                    initialPrice = selectedPasta.getPrice2();
//                                    Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                                    break;
                                case "Large, 500 Ml":
                                    initialPrice = selectedPasta.getPrice3();
//                                    Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                            // Сбрасываем counter на 1 при изменении значения
                            counter = 1;

                            // Обновляем TextView для counter
                            updateCounter();
                        }
                    }

                    // Устанавливаем соответствующий Price в TextView
                    if (initialPrice != -1) {
                        textView3.setText("" + initialPrice);
                    } else {
                        Log.d("MyApp", "Invalid selection: " + selectedValue);
                        textView3.setText("Invalid selection");
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) {
                    // Выполняется, если ничего не выбрано
                }
            });
            // Создаем адаптер для Spinner
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, values);
            // Устанавливаем адаптер для Spinner
            spinner.setAdapter(adapter);

            // Устанавливаем стиль выпадающего списка
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        }
    }

    private void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Подтверждаете выбор?")
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Действие при нажатии "Да"
                        // Можно добавить свой код здесь
                        Intent intent = new Intent(ProductSelection.this, Orders.class);
                        // Помещаем данные в Intent
                        // Замените selectedImage на ваш реальный источник изображения
                        intent.putExtra("image", selectedPizza.getImageId());
                        intent.putExtra("name", textView1.getText().toString());
                        intent.putExtra("spinnerItem", selectedValue);
                        intent.putExtra("price", textView3.getText().toString());
                        intent.putExtra("quantity", counter);
                        startActivity(intent);
                        dialog.dismiss(); // Закрываем диалог
                    }
                })
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Действие при нажатии "Нет"
                        // Можно добавить свой код здесь
                        dialog.dismiss(); // Закрываем диалог
                    }
                });
        // Создаем и отображаем диалог
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    // Обновление TextView с текущим значением
    private void updateCounter() {
        textView.setText(String.valueOf(counter));
    }
    private void updatePrice(int initialPrice) {
        // Вычисление нового значения Price с учетом ограничения
        int updatedPrice = initialPrice * counter;
        // Обновление текста в TextView
        textView3.setText("" + updatedPrice);
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
        } else if (id == R.id.stores) {
            Toast.makeText(this, "This is View", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.buy) {
            Intent intent = new Intent(this, Orders.class);
            startActivity(intent);
            Toast.makeText(this, "Order", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}