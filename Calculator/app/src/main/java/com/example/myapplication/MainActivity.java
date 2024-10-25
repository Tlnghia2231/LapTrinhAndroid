package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sharedPreferences = getSharedPreferences("PhepTinh", MODE_PRIVATE);


        EditText number1 = (EditText)findViewById(R.id.editTextNumber);
        EditText number2 = (EditText)findViewById(R.id.editTextNumber2);
        TextView out = (TextView)findViewById(R.id.textView5);
        Button btn1 = (Button)findViewById(R.id.button);
        Button btn2 = (Button)findViewById(R.id.button2);
        Button btn3 = (Button)findViewById(R.id.button3);
        Button btn4 = (Button)findViewById(R.id.button4);

        out.setText(sharedPreferences.getString("result", ""));

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(number1.getText().toString());
                int n2 = Integer.parseInt(number2.getText().toString());
                String result = n1 + " + " + n2 + " = " + (n1 + n2);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("result", result);
                out.setText(result);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(number1.getText().toString());
                int n2 = Integer.parseInt(number2.getText().toString());
                String result = n1 + " - " + n2 + " = " + (n1 - n2);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("result", result);
                out.setText(result);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(number1.getText().toString());
                int n2 = Integer.parseInt(number2.getText().toString());
                String result = n1 + " * " + n2 + " = " + (n1 * n2);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("result", result);
                out.setText(result);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(number1.getText().toString());
                int n2 = Integer.parseInt(number2.getText().toString());
                String result = n1 + " / " + n2 + " = " + ((n1 * 1.0) / n2);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("result", result);
                out.setText(result);
            }
        });
    }
}