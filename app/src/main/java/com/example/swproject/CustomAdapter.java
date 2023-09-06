package com.example.swproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<challenge> arrayList;
    private Context context;

    public CustomAdapter(ArrayList<challenge> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tv_id.setText(String.valueOf(arrayList.get(position).getC_id()));
        holder.tv_id2.setText(arrayList.get(position).getC_type());
        holder.tv_id3.setText(arrayList.get(position).getC_detail());
        holder.tv_point.setText(String.valueOf(arrayList.get(position).getC_point()));
        holder.tv_diff.setText(arrayList.get(position).getDifficulty());
        holder.tv_deadline.setText(arrayList.get(position).getDeadline());

    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0); //널이아니면 사이즈 구하고 널이면 0 해라
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView tv_id;
        TextView tv_id2;
        TextView tv_id3;
        TextView tv_point;
        TextView tv_diff;
        TextView tv_deadline;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_id = itemView.findViewById(R.id.tv_id);
            this.tv_id2 = itemView.findViewById(R.id.tv_id2);
            this.tv_id3 = itemView.findViewById(R.id.tv_id3);
            this.tv_point = itemView.findViewById(R.id.tv_point);
            this.tv_diff = itemView.findViewById(R.id.tv_diff);
            this.tv_deadline = itemView.findViewById(R.id.tv_deadline);

        }
    }
}
