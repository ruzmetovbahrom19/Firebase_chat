package com.example.firebase2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    Context context;
    ArrayList<Chat> chatArrayList;

    public ChatAdapter(Context context, ArrayList<Chat> chatArrayList) {
        this.context = context;
        this.chatArrayList = chatArrayList;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.chatleft,parent,false);


        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {

        holder.textView1.setText(chatArrayList.get(position).getUsername());
        holder.textView2.setText(chatArrayList.get(position).getMessage());
        holder.textView3.setText(chatArrayList.get(position).getDatatime());
    }

    @Override
    public int getItemCount() {
        return chatArrayList.size();
    }

    class ChatViewHolder extends RecyclerView.ViewHolder {
        TextView textView1,textView2,textView3,textView4;
        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.textview1);
            textView2=itemView.findViewById(R.id.textview2);
            textView3=itemView.findViewById(R.id.textview3);
        }
    }
}
