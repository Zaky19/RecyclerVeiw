package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<item3> dataItem;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txthead;
        TextView txtshead;
        ImageView imageView;
        LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txthead = itemView.findViewById(R.id.title);
            txtshead = itemView.findViewById(R.id.title2);
            imageView = itemView.findViewById(R.id.listimage);
            layout = itemView.findViewById(R.id.layout);
        }
    }

    Adapter(Context context,ArrayList<item3> dataItem) {
        this.context = context;
        this.dataItem = dataItem;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        TextView txthead = holder.txthead;
        TextView txtshead = holder.txtshead;
        ImageView imageView = holder.imageView;

        txthead.setText(dataItem.get(position).getName());
        txtshead.setText(dataItem.get(position).getType());
        imageView.setImageResource(dataItem.get(position).getImage());

        holder.layout.setOnClickListener(view -> {
            Toast.makeText(context, dataItem.get(position).getName(), Toast.LENGTH_SHORT).show();

        if (dataItem.get(position).getName().equals("ubuntu")) {
            context.startActivity(new Intent(context, ubuntu.class));
        }
        if (dataItem.get(position).getName().equals("wa")) {
            context.startActivity(new Intent(context, WhatsApp.class));
        }
        if (dataItem.get(position).getName().equals("zoom")) {
            context.startActivity(new Intent(context, Zoom.class));
        }
        });

    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }
}
