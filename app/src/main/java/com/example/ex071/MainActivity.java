package com.example.ex071;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Intent si;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.et);
    }

    public void nextPage(View view) {
        si = new Intent(this, SecondActivity.class);
        startActivity(si);
    }

    public void plus(View view) {
        if(isValidAction()) {
            et.setText(et.getText().toString() + "+");
        }
    }

    public void minus(View view) {
        if(isValidAction()) {
            et.setText(et.getText().toString() + "-");
        }
    }

    public void mul(View view) {
        if(isValidAction()) {
            et.setText(et.getText().toString() + "*");
        }
    }

    public void div(View view) {
        if(isValidAction()) {
            et.setText(et.getText().toString() + "/");
        }
    }

    public void reset(View view) {
        et.setText("");
    }

    public void equals(View view) {
    }

    public boolean isValidAction(){
        String text = et.getText().toString();
        int lastIndex = text.length() - 1;

        if(text.length() > 0){
            return (text.charAt(lastIndex) != '+') && (text.charAt(lastIndex) != '-')
                    && (text.charAt(lastIndex) != '*') && (text.charAt(lastIndex) != '/');
        }

        return false;
    }
}