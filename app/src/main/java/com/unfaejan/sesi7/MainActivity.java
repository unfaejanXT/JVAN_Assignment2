package com.unfaejan.sesi7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private int count = 0;

    private EditText editText;
    private TextView counterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterTextView = findViewById(R.id.counterTextView);
        editText = findViewById(R.id.editText);

        Button countButton = findViewById(R.id.countButton);
        countButton.setOnClickListener(view -> {
            count++;
            counterTextView.setText(String.valueOf(count));
        });

        if(savedInstanceState != null){
            count = savedInstanceState.getInt("count",0);
            counterTextView.setText(String.valueOf(count));
            String savedText = savedInstanceState.getString("text","");
            editText.setText(savedText);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("count",count);
        outState.putString("text", editText.getText().toString() );
    }
}