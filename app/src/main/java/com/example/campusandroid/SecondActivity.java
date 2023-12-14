package com.example.campusandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btn = findViewById(R.id.btn);
        Button btn2 = findViewById(R.id.btn2);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// onBackPressed();
// finish();
                String msg = null;
                if (v.getId() == R.id.btn)
                    msg = "BTN-1";
                else if (v.getId() == R.id.btn2) {
                    msg = "BTN-2";
                }

                Toast.makeText(getApplicationContext(), "My btn clicked: " + msg, Toast.LENGTH_LONG).show();
            }
        };
        btn.setOnClickListener(listener);
// btn2.setOnClickListener(listener);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.textView);
                textView.setText(textView.getText() + "\n" + "New Line");

                ScrollView scrollView = findViewById(R.id.scrollView);
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Exit");
        builder.setMessage("Are you sure?");
        builder.setCancelable(false);
// builder.setIcon(R.mipmap.ic_launcher);
        builder.setIcon(android.R.drawable.ic_dialog_email);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

// builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
// @Override
// public void onClick(DialogInterface dialog, int which) {
// Toast.makeText(getApplicationContext(), "No clicked: " + which, Toast.LENGTH_LONG).show();
// }
// });
// builder.setNeutralButton("Cancel", null);
        builder.setNegativeButton("Cancel", null);


// DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
// @Override
// public void onClick(DialogInterface dialog, int which) {
// String msg = null;
// if (which == AlertDialog.BUTTON_POSITIVE)
// msg = "Yes";
// else if (which == AlertDialog.BUTTON_NEGATIVE)
// msg = "No";
// Toast.makeText(getApplicationContext(), "Btn clicked: " + msg, Toast.LENGTH_LONG).show();
// }
// };
// builder.setPositiveButton("Yes", listener);
// builder.setNegativeButton("No", listener);

        builder.create().show();

    }
}
