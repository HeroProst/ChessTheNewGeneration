package com.example.cours_project.SupportClass;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cours_project.R;

import java.util.List;

public class ListFigureAdapter extends RecyclerView.Adapter<ListFigureAdapter.ListFigureHolder> {

    Context context;
    List<ListFigure> listFigure;

    public static Drawable DrawableListFigure;
    public static String TagListFigure;

    public ListFigureAdapter(Context context, List<com.example.cours_project.SupportClass.ListFigure> listFigure) {
        this.context = context;
        this.listFigure = listFigure;
    }

    @NonNull
    @Override
    public ListFigureHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listFigureItem = LayoutInflater.from(context).inflate(R.layout.list_figure_item, parent, false);
        return new ListFigureHolder(listFigureItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ListFigureHolder holder, int position) {
        holder.item_name.setText(listFigure.get(position).getName());
        holder.item_price.setText(String.valueOf(listFigure.get(position).getPrice()));
        holder.item_image.setImageResource(listFigure.get(position).getImageId());

        holder.itemView.setTag(listFigure.get(position).getTag());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawableListFigure = holder.item_image.getDrawable();
                TagListFigure = String.valueOf(holder.itemView.getTag());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listFigure.size();
    }

    public class ListFigureHolder extends RecyclerView.ViewHolder {

        TextView item_price;
        TextView item_name;
        ImageView item_image;

        public ListFigureHolder(@NonNull View itemView) {
            super(itemView);

            item_price = itemView.findViewById(R.id.item_price);
            item_name = itemView.findViewById(R.id.item_name);
            item_image = itemView.findViewById(R.id.item_image);
        }
    }
}
