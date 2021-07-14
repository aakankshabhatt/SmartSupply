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

public class RAdapter extends RecyclerView.Adapter<RAdapter.MyViewHolder> {

    ArrayList<Retail> mList;
    Context context;

    public RAdapter(Context context,ArrayList<Retail> mList){

        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.ritem, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Retail list =mList.get(position);

        holder.rm_rview.setText(list.getRaw_material());
        holder.from_rview.setText(list.getFrom());
        holder.to_rview.setText(list.getTo());
        holder.quant_rview.setText(list.getQuantity());
        holder.loc_rview.setText(list.getLocation());
    }

    @Override
    public int getItemCount() {
        Log.d("RAdapter", "getItemCount: "+mList.size());
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView rm_rview, from_rview, to_rview,quant_rview, loc_rview;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            rm_rview=itemView.findViewById(R.id.rm_rview);
            from_rview=itemView.findViewById(R.id.from_rview);
            to_rview=itemView.findViewById(R.id.to_rview);
            quant_rview=itemView.findViewById(R.id.quant_rview);
            loc_rview=itemView.findViewById(R.id.loc_rview);
        }
    }
}
