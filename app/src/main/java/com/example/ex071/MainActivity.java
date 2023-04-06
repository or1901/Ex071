package com.example.ex071;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Intent si;

    // Variables for input validity check
    String expression;
    int lastIndex;

    // Variables for the expression calculating
    double finalResult = 0;
    String[] parts;
    double mulResult;
    double divResult;
    String currentPhrase;
    String[] mulSplit;
    String[] divSplit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.et);
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
        if(isValidAction()) {
            expression = et.getText().toString();

            expression = expression.replace("-", "+-");

            parts = expression.split("\\+");
            finalResult = 0;

            for(int i = 0; i < parts.length; i++) {
                mulSplit = parts[i].split("\\*");
                mulResult = 1;

                for (int j = 0; j < mulSplit.length; j++) {
                    currentPhrase = mulSplit[j];

                    if (currentPhrase.contains("/")) {
                        divSplit = currentPhrase.split("/");
                        divResult = Double.parseDouble(divSplit[0]) / Double.parseDouble(divSplit[1]);

                        mulResult *= divResult;
                    } else
                        mulResult *= Double.parseDouble(currentPhrase);
                }
                finalResult += mulResult;
            }

            et.setText("" + finalResult);
        }
        else
            et.setText("Error");


    }

    public void nextPage(View view) {
        si = new Intent(this, SecondActivity.class);

        si.putExtra("result", finalResult);
        startActivity(si);
    }

    public boolean isValidAction(){
        expression = et.getText().toString();
        lastIndex = expression.length() - 1;

        if(expression.length() > 0){
            return (expression.charAt(lastIndex) != '+') && (expression.charAt(lastIndex) != '-')
                    && (expression.charAt(lastIndex) != '*') && (expression.charAt(lastIndex) != '/')
                    && (!expression.contains("E")) && (!expression.contains("/0"));
        }

        return false;
    }
}