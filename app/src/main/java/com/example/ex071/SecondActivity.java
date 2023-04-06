package com.example.ex071;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    Intent gi;
    TextView txtView;
    double lastResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtView = findViewById(R.id.txtView);

        gi = getIntent();
        lastResult = gi.getDoubleExtra("result", 0);

        txtView.setText("" + lastResult);


    }

    public void back(View view) {
        finish();
    }
}