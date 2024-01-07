package com.betelgeuse.corp.papajohns;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class Orders extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        setTitle("Orders");


        // Получаем данные из Intent
        Intent intent = getIntent();
        int image = intent.getIntExtra("image", 0);  // Замените 0 на значение по умолчанию, если необходимо
        String name = intent.getStringExtra("name");
        String spinnerItem = intent.getStringExtra("spinnerItem");
        int price = intent.getIntExtra("price", 0);  // Замените 0 на значение по умолчанию, если необходимо
        int quantity = intent.getIntExtra("quantity", 0);  // Замените 0 на значение по умолчанию, если необходимо

        // Ваши дальнейшие действия с полученными данными
        // Например, вывод на экран или обработка заказа
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
//        RelativeLayout relativeLayout = findViewById(R.id.firstActivity);
        if (id == R.id.deleteAll){
            Toast.makeText(this, "DELETE ALL", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    class OrderAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }
}
class Order implements Serializable{

}