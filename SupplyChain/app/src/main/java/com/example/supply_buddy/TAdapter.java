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

public class TAdapter extends RecyclerView.Adapter<TAdapter.MyViewHolder> {

    ArrayList<Transporter> mList;
    Context context;

    public TAdapter(Context context,ArrayList<Transporter> mList){

        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.titem, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Transporter list =mList.get(position);


        holder.quant_tview.setText(list.getQuantity());
        holder.box_tview.setText(list.getBoxes());
        holder.loc_tview.setText(list.getLocation());
        holder.cp_tview.setText(list.getConfirmPrize());
    }

    @Override
    public int getItemCount() {

        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView quant_tview, box_tview,loc_tview, cp_tview;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            quant_tview=itemView.findViewById(R.id.quant_tview);
            box_tview=itemView.findViewById(R.id.box_tview);
            loc_tview=itemView.findViewById(R.id.loc_tview);
            cp_tview=itemView.findViewById(R.id.cp_tview);
        }
    }
}

