package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication2.adapters.CategoryAdapter;
import com.example.myapplication2.adapters.ServiceAdapter;
import com.example.myapplication2.models.Category;
import com.example.myapplication2.models.Service;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, serviceRecycler;
    CategoryAdapter categoryAdapter;
    static ServiceAdapter serviceAdapter;
    static List<Service> serviceList = new ArrayList<>();
    static List<Service> fullServiceList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Repair"));
        categoryList.add(new Category(2, "Painting"));
        categoryList.add(new Category(3, "Cleaning"));

        setCategoryRecycler(categoryList);

        serviceList.add(new Service(1, "service_card1", "Basic car service", "1-2 Hours", "$", "#664c36", "Basic car maintenance includes replacement of consumables, \n" +
                "light repairs and replacement of body parts.\n" +
                "The cost of the service and the terms of repair are discussed directly in the service in your presence.", 1));
        serviceList.add(new Service(2, "service_card2", "Advanced car service", "1-3 Days", "$$$", "#451919", "Car maintenance includes the replacement of spare parts, \n" +
                "repair of the engine compartment, chassis, transmission, electrical wiring,\n" +
                "and other complex repairs.\n" +
                "The cost of the service and the terms of repair are discussed directly in the service in your presence.", 1));
        serviceList.add(new Service(3, "service_card8", "Body painting", "1-2 Days", "$$$", "#058957", "Includes car body painting, polishing, priming, car body varnishing.\n" +
                "The cost and terms of delivery depend on the options chosen.", 2));
        serviceList.add(new Service(4, "service_card7", "Parts painting", "1-2 Days", "$$", "#907B01", "Includes painting or finishing individual car body parts.\n" +
                "The cost and terms of delivery depend on the amount of work and the selected options.", 2));
        serviceList.add(new Service(5, "service_card4", "Car cleaning", "1-2 Hours", "$", "#27A1B7", "Includes dry and wet cleaning of the car interior.\\n\" +\n" +
                "                \"Price fixed at $40", 3));
        serviceList.add(new Service(6, "service_card5", "Car washing", ".5-1 Hour", "$", "#083885", "Includes pressure washer and car drying.\\n\" +\n" +
                "                \"Price fixed at $15", 3));

        fullServiceList.addAll(serviceList);

        setServiceRecycler(serviceList);
    }

    public void openCart (View view) {
        Intent intent = new Intent(this, OrderPage.class);
        startActivity(intent);
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

    public static void showServicesByCategory(int category){

        serviceList.clear();
        serviceList.addAll(fullServiceList);


        List<Service> filteredServices = new ArrayList<>();

        for (Service c : serviceList) {
            if(c.getCategory() == category)
                filteredServices.add(c);
        }

        serviceList.clear();
        serviceList.addAll(filteredServices);

        serviceAdapter.notifyDataSetChanged();
    }

}