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

public class FAdapter extends RecyclerView.Adapter<FAdapter.MyViewHolder> {

    ArrayList<Farmer> mList;
    Context context;

    public FAdapter(Context context,ArrayList<Farmer> mList){

        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Farmer list =mList.get(position);
        Log.d("FAdapter",list.getName());
        holder.name_view.setText(list.getName());
        holder.rm_view.setText(list.getRaw_material());
        holder.from_view.setText(list.getFrom());
        holder.to_view.setText(list.getTo());
        holder.quant_view.setText(list.getQuantity());
        holder.loc_view.setText(list.getLocation());
    }

    @Override
    public int getItemCount() {
        Log.d("FAdapter", "getItemCount: "+mList.size());
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name_view, rm_view, from_view, to_view,quant_view, loc_view;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name_view=itemView.findViewById(R.id.name_view);
            rm_view=itemView.findViewById(R.id.rm_view);
            from_view=itemView.findViewById(R.id.from_view);
            to_view=itemView.findViewById(R.id.to_view);
            quant_view=itemView.findViewById(R.id.quant_view);
            loc_view=itemView.findViewById(R.id.loc_view);
        }
    }
}

