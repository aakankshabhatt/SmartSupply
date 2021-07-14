package com.example.supply_buddy;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GAdapter extends RecyclerView.Adapter<GAdapter.MyViewHolder> {

    ArrayList<Godown> mList;
    Context context;

    public GAdapter(Context context,ArrayList<Godown> mList){

        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.gitem, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Godown list =mList.get(position);
        Log.d("GAdapter",list.getDate());
        holder.date_view.setText(list.getDate());
        holder.time_view.setText(list.getTime());
        holder.quant_gview.setText(list.getQuantity());
    }

    @Override
    public int getItemCount() {
        Log.d("GAdapter", "getItemCount: "+mList.size());
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView date_view, time_view,quant_gview;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            date_view=itemView.findViewById(R.id.date_view);
            time_view=itemView.findViewById(R.id.time_view);
            quant_gview=itemView.findViewById(R.id.quant_gview);
        }
    }
}
