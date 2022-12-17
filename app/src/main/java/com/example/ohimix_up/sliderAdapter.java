package com.example.ohimix_up;

import android.content.ClipData;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;

public class sliderAdapter extends RecyclerView.Adapter<sliderAdapter.MyViewHolder> {

    private ArrayList<SlideItem> list = new ArrayList<SlideItem>();


    public static class MyViewHolder extends ViewHolder{

        View view;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            this.view=itemView;
        }
    }

    public sliderAdapter(ArrayList<SlideItem> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        View view=holder.view;

        TextView txtWord1=view.findViewById(R.id.txtWord1);
        TextView txtWord1Mean=view.findViewById(R.id.txtWord1Mean);
        TextView txtWord2=view.findViewById(R.id.txtWord2);
        TextView txtWord2Mean=view.findViewById(R.id.txtWord2Mean);

        txtWord1.setText(list.get(position).getWord1());
        txtWord1Mean.setText(list.get(position).getContent1());
        txtWord2.setText(list.get(position).getWord2());
        txtWord2Mean.setText(list.get(position).getContent2());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onViewAttachedToWindow(@NonNull MyViewHolder holder) {

        View mainFragment = holder.view.findViewById(R.id.mainFragment);
        SlideItem item = list.get(holder.getAbsoluteAdapterPosition());

        super.onViewAttachedToWindow(holder);
    }
}
