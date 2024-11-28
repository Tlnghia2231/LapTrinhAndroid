package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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

        DBHelper db = new DBHelper(this);

        EditText id = findViewById(R.id.editTextText);
        EditText name = findViewById(R.id.editTextText2);
        Button viewbtn = findViewById(R.id.button3);
        Button insertbtn = findViewById(R.id.button);
        Button updatetbtn = findViewById(R.id.button2);
        Button deletebtn = findViewById(R.id.button4);
        RecyclerView rcv = findViewById(R.id.rcv);
        rcv.setLayoutManager(new LinearLayoutManager(this));


        insertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String col1 = id.getText().toString();
                int col2 = Integer.parseInt(name.getText().toString());
                Boolean in = db.insert(col1, col2);
                if (in) {
                    Toast.makeText(MainActivity.this, "New Entry Inserted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "New Entry Not Inserted", Toast.LENGTH_LONG).show();
                }
            }
        });

        viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Number> numberList = new ArrayList<Number>();
                numberList = db.show();
                Adapter apt = new Adapter(numberList);
                rcv.setAdapter(apt);
                apt.notifyDataSetChanged();
            }
        });

        updatetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String col1 = id.getText().toString();
                int col2 = Integer.parseInt(name.getText().toString());
                Boolean in = db.update(col1, col2);
                if (in) {
                    Toast.makeText(MainActivity.this, "New Entry Updated", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "New Entry Not Updated", Toast.LENGTH_LONG).show();
                }
            }
        });

        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String col1 = id.getText().toString();
                Boolean in = db.delete(col1);
                if (in) {
                    Toast.makeText(MainActivity.this, "New Entry Deleted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "New Entry Not Deleted", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}