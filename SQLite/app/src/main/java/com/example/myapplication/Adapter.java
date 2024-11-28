package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private List<Number> l_number;

    private String id;
    private int number;

    public Adapter(List<Number> l_number) {
        this.l_number = l_number;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Number tmp = l_number.get(position);
        holder.id.setText(tmp.id);
        holder.number.setText(String.valueOf(tmp.number));
    }

    @Override
    public int getItemCount() {
        return l_number.size();
    }


    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView id, number;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.textView);
            number = itemView.findViewById(R.id.textView2);
        }
    }
}
