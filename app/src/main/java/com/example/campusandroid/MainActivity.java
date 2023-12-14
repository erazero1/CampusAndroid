package com.example.campusandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.myLabel);
        EditText editText = findViewById(R.id.FirsteditTextNumberDecimal);
        EditText editText1 = findViewById(R.id.SecondeditTextNumberDecimal);
        Button AddButton = findViewById(R.id.AdditionButton);
        Button MultiplyButton = findViewById(R.id.MultiplicationButton);
        Button SubtractButton = findViewById(R.id.SubtractionButton);
        Button DivideButton = findViewById(R.id.DivideButton);
        Button TriangleCalc = findViewById(R.id.buttonTriangle);

        View.OnClickListener listener2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        };

        TriangleCalc.setOnClickListener(listener2);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "";
                Button button = (Button) view;
                double result = 0;
                double firstValue = Double.parseDouble(String.valueOf(editText.getText()));
                double secondValue = Double.parseDouble(String.valueOf(editText1.getText()));
                if (button.getText().equals("+")) {
                    result = firstValue + secondValue;
                }
                if (button.getText().equals("*")) {
                    result = firstValue * secondValue;
                }
                if (button.getText().equals("-")) {
                    result = firstValue - secondValue;
                }
                if (button.getText().equals("/")) {
                    if(secondValue == 0.0){
                        str = "You can't divide by zero";
                    }
                    else{
                        result = firstValue / secondValue;
                    }
                }

                if (str.equals("")) {
                    str = firstValue + " " + button.getText() + " " + secondValue + " = " + result;
                }
                textView.setText(str);


            }
        };


        AddButton.setOnClickListener(listener);
        MultiplyButton.setOnClickListener(listener);
        SubtractButton.setOnClickListener(listener);
        DivideButton.setOnClickListener(listener);


    }
}