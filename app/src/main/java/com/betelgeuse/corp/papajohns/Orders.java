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
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Orders extends AppCompatActivity {
    List<Order> AllOrdersCards = new ArrayList<>();
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        setTitle("Orders");

        // Получаем данные из Intent
        Intent intent = getIntent();
        ListView listView = findViewById(R.id.listOrder);


        int image = intent.getIntExtra("image", 0);  // Замените 0 на значение по умолчанию, если необходимо
        String name = intent.getStringExtra("name");
        String spinnerItem = intent.getStringExtra("spinnerItem");
        int price = intent.getIntExtra("price", 0);  // Замените 0 на значение по умолчанию, если необходимо
        int quantity = intent.getIntExtra("quantity", 0);  // Замените 0 на значение по умолчанию, если необходимо

        // Ваши дальнейшие действия с полученными данными
        // Например, вывод на экран или обработка заказа


        Order[] AllOrdersString = (Order[]) intent.getSerializableExtra("orders");
        if (AllOrdersString != null){
            for (int i = 0; i < AllOrdersString.length; i++) {
                AllOrdersCards.add(AllOrdersString[i]);
            }
        }
        AllOrdersCards.add(new Order("Italian",R.drawable.picca,"Small: 120 Cm","1","2500"));

        // Создайте адаптер для списка:
        OrderAdapter orderAdapter = new OrderAdapter(AllOrdersCards, this, R.layout.card_product_order);
        // Установите адаптер для списка:
        listView.setAdapter(orderAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.deleteAll){
            Toast.makeText(this, "DELETE ALL", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    class OrderAdapter extends BaseAdapter {
        List<Order> AllOrders;
        Context context;
        int TemplateLayout;
        LayoutInflater inflater;

        public OrderAdapter(List<Order> allOrders, Context context, int templateLayout) {
            AllOrders = allOrders;
            this.context = context;
            TemplateLayout = templateLayout;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return AllOrders.size();
        }

        @Override
        public Object getItem(int position) {
            return AllOrders.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = inflater.inflate(TemplateLayout, parent, false);
            TextView name = view.findViewById(R.id.nameOrder);
            TextView size = view.findViewById(R.id.productSize);
            TextView productOrder = view.findViewById(R.id.valueProductOrder);
            TextView priseOrder = view.findViewById(R.id.priseOrderValue);
            ImageView photo = view.findViewById(R.id.imgOrder);
            Order order = AllOrders.get(position);
            name.setText(order.getName());
            size.setText(order.getSizeID());
            productOrder.setText(order.getProductOrderID());
            priseOrder.setText(order.getPriseOrderID());
            photo.setImageResource(order.getImageId());
            return view;
        }
    }
}
class Order implements Serializable{
    String Name;
    int ImageId;
    String SizeID;
    String ProductOrderID;
    String PriseOrderID;
    String priseTotalID;

    public Order(String name, int imageId, String sizeID, String productOrderID, String priseOrderID) {
        Name = name;
        ImageId = imageId;
        SizeID = sizeID;
        ProductOrderID = productOrderID;
        PriseOrderID = priseOrderID;
    }

    public Order() {
    }

    public String getSizeID() {
        return SizeID;
    }

    public void setSizeID(String sizeID) {
        SizeID = sizeID;
    }

    public String getProductOrderID() {
        return ProductOrderID;
    }

    public void setProductOrderID(String productOrderID) {
        ProductOrderID = productOrderID;
    }

    public String getPriseOrderID() {
        return PriseOrderID;
    }

    public void setPriseOrderID(String priseOrderID) {
        PriseOrderID = priseOrderID;
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
