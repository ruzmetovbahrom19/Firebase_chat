package com.example.firebase2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {

    EditText editText;
    ImageView imageView;
    Chat chat;
    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    ChatAdapter chatAdapter;
    ArrayList<Chat> chatArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Chats");
        recyclerView=findViewById(R.id.recyclerview1);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        editText=findViewById(R.id.edittextyozishma);
        imageView=findViewById(R.id.imageviewsend);
        chatArrayList=new ArrayList<>();


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar=Calendar.getInstance();
                int hour=calendar.get(Calendar.HOUR_OF_DAY);
                int minute=calendar.get(Calendar.MINUTE);
                chat=new Chat();
                chat.setUsername(name);
                chat.setMessage(editText.getText().toString());
                chat.setDatatime(hour+" : "+minute);
                databaseReference.push().setValue(chat);
                editText.setText("");
            }
        });

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                chatArrayList.clear();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Chat chat1=dataSnapshot.getValue(Chat.class);
                    chatArrayList.add(chat1);

                }
                chatAdapter=new ChatAdapter(MainActivity2.this,chatArrayList);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity2.this));
                recyclerView.setAdapter(chatAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}