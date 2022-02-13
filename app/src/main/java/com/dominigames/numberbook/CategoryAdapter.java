package com.dominigames.numberbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    Context context;
    List<Category> contacts;

    public CategoryAdapter(Context context, List<Category> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View contactsItems = LayoutInflater.from(context).inflate(R.layout.contact_item, parent, false);
        return new CategoryViewHolder(contactsItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {
        holder.contact_name.setText(contacts.get(position).getName());
        holder.contact_number.setText(contacts.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static final class CategoryViewHolder extends RecyclerView.ViewHolder{

        TextView contact_name;
        TextView contact_number;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            contact_name = itemView.findViewById(R.id.contact_name_id);
            contact_number = itemView.findViewById(R.id.contact_number_id);
        }
    }
}
