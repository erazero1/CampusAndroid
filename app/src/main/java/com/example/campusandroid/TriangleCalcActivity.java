package com.example.campusandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TriangleCalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle_calc);

        EditText valueOfA = findViewById(R.id.valueOfA);
        EditText valueOfB = findViewById(R.id.valueOfB);
        EditText valueOfC = findViewById(R.id.valueOfC);
        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.areaOfTriangle);
        Button backButton = findViewById(R.id.backButton);

        View.OnClickListener listener2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        };


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a = Double.parseDouble(String.valueOf(valueOfA.getText()));
                double b = Double.parseDouble(String.valueOf(valueOfB.getText()));
                double c = Double.parseDouble(String.valueOf(valueOfC.getText()));
                double semiPerimeter = (a + b + c) / 2;
                double area = Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
                textView.setText(String.valueOf(area));
            }
        };

        button.setOnClickListener(listener);
        backButton.setOnClickListener(listener2);

    }
}