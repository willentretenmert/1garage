package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication2.adapters.CategoryAdapter;
import com.example.myapplication2.adapters.ServiceAdapter;
import com.example.myapplication2.models.Category;
import com.example.myapplication2.models.Service;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, serviceRecycler;
    CategoryAdapter categoryAdapter;
    ServiceAdapter serviceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Repair"));
        categoryList.add(new Category(2, "Painting"));
        categoryList.add(new Category(3, "Cleaning"));
        categoryList.add(new Category(4, "Tools"));

        setCategoryRecycler(categoryList);

        List<Service> serviceList = new ArrayList<>();
        serviceList.add(new Service(1, "service_card1", "Basic service", "1-2 Hours", "$", "#424345"));
        serviceList.add(new Service(2, "service_card2", "Advanced service", "1-3 Days", "$$$", "#B05F23"));
        setServiceRecycler(serviceList);
    }

    private void setServiceRecycler(List<Service> serviceList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        serviceRecycler = findViewById(R.id.serviceRecycler);
        serviceRecycler.setLayoutManager(layoutManager);

        serviceAdapter = new ServiceAdapter(this, serviceList);
        serviceRecycler.setAdapter(serviceAdapter);

    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);

    }
}