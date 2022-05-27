package com.example.myapplication2.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.R;
import com.example.myapplication2.models.Service;

import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder> {

    Context context;
    List<Service> services;

    public ServiceAdapter(Context context, List<Service> services) {
        this.context = context;
        this.services = services;
    }

    @NonNull
    @Override
    public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View serviceItems = LayoutInflater.from(context).inflate(R.layout.service_item, parent, false);
        return new ServiceAdapter.ServiceViewHolder(serviceItems);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceViewHolder holder, int position) {
        holder.serviceBg.setCardBackgroundColor(Color.parseColor(services.get(position).getColor()));

        int imageId = context.getResources().getIdentifier("ic_" + services.get(position).getImg(), "drawable", context.getPackageName());
        holder.serviceImage.setImageResource(imageId);

        holder.serviceTitle.setText(services.get(position).getTitle());
        holder.serviceDuration.setText(services.get(position).getDuration());
        holder.servicePrice.setText(services.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return services.size();
    }

    public static final class ServiceViewHolder extends RecyclerView.ViewHolder {

        CardView serviceBg;
        ImageView serviceImage;
        TextView serviceTitle, serviceDuration, servicePrice;

        public ServiceViewHolder(@NonNull View itemView) {
            super(itemView);

            serviceBg = itemView.findViewById(R.id.serviceBg);
            serviceImage = itemView.findViewById(R.id.serviceImage);
            serviceTitle = itemView.findViewById(R.id.serviceTitle);
            serviceDuration = itemView.findViewById(R.id.serviceDuration);
            servicePrice = itemView.findViewById(R.id.servicePrice);
        }
    }
}
