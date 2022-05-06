package com.example.firebase2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText editText1,editText2;
    Button button1,button2;
    ProgressBar progressBar;

    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=findViewById(R.id.edittext1);
        editText2=findViewById(R.id.edittext2);
        button1=findViewById(R.id.button1);

        button1.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            intent.putExtra("name",editText1.getText().toString());
            startActivity(intent);
        });
    }
}