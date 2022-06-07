package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication2.models.Order;

public class ServicePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_page);

        ConstraintLayout serviceBg = findViewById(R.id.servicePageBg);
        ImageView serviceImage = findViewById(R.id.servicePageImage);
        TextView serviceTitle = findViewById(R.id.servicePageTitle);
        TextView serviceDuration = findViewById(R.id.servicePageDuration);
        TextView servicePrice = findViewById(R.id.servicePagePrice);
        TextView serviceText = findViewById(R.id.servicePageText);

        serviceBg.setBackgroundColor(getIntent().getIntExtra("serviceBg", 0));
        serviceImage.setImageResource(getIntent().getIntExtra("serviceImage", 0));
        serviceTitle.setText(getIntent().getStringExtra("serviceTitle"));
        serviceDuration.setText(getIntent().getStringExtra("serviceDuration"));
        servicePrice.setText(getIntent().getStringExtra("servicePrice"));
        serviceText.setText(getIntent().getStringExtra("serviceText"));
    }

    public void addToCart(View view) {
        int item_id = getIntent().getIntExtra("serviceId", 0);
        Order.items_id.add(item_id);
        Toast.makeText(this, "Successfully added to cart!", Toast.LENGTH_LONG).show();
    }

}