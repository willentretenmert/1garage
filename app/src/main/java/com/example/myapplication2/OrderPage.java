package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication2.models.Order;
import com.example.myapplication2.models.Service;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        ListView orders_list = findViewById(R.id.orders_list);

        List<String> serviceTitle = new ArrayList<>();
        for(Service c : MainActivity.fullServiceList) {
            if(Order.items_id.contains(c.getId())) {
                serviceTitle.add(c.getTitle());
            }
        }

        orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, serviceTitle));
    }
}