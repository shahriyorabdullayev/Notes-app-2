package com.example.notessql_lite_java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notessql_lite_java.R;
import com.example.notessql_lite_java.database.model.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<Note> items;

    public NoteAdapter(Context context, ArrayList<Note> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NoteVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Note item = items.get(position);

        if (holder instanceof NoteVH) {
            ((NoteVH) holder).tvNote.setText(item.getNote());
            ((NoteVH) holder).tvDate.setText(item.getTimestamp());
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class NoteVH extends RecyclerView.ViewHolder{
        TextView tvDate;
        TextView tvNote;

        public NoteVH(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tv_data);
            tvNote = itemView.findViewById(R.id.tv_note);
        }
    }
}
