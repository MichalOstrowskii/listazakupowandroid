package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context context;
    private ArrayList nazwa, ilosc;

    public Adapter(Context context, ArrayList nazwa, ArrayList ilosc) {
        this.context = context;
        this.nazwa = nazwa;
        this.ilosc = ilosc;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.ilosc.setText(String.valueOf(ilosc.get(position)));
    holder.nazwa.setText(String.valueOf(nazwa.get(position)));
    }

    @Override
    public int getItemCount() {
        return nazwa.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nazwa,ilosc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nazwa = itemView.findViewById(R.id.textnazwa);
            ilosc = itemView.findViewById(R.id.textilosc);
        }
    }
}
