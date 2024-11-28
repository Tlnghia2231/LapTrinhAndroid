package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText txtUserName, txtPassword;
    private Button btnLogin;
    private CheckBox checkBox;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });



        txtUserName = (EditText)findViewById(R.id.txtUserName);
        txtPassword = (EditText)findViewById(R.id.txtPassword);
        checkBox = (CheckBox)findViewById(R.id.checkbox_save);
        btnLogin = (Button)findViewById(R.id.btLogin);

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        txtUserName.setText(sharedPreferences.getString("username", ""));
        txtPassword.setText(sharedPreferences.getString("password", ""));
        checkBox.setChecked(sharedPreferences.getBoolean("checked", false));

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "Login", Toast.LENGTH_SHORT);
                String msv = "1";
                String ten = "tranlamnghia";
                if ((txtUserName.equals(ten.trim())) & (txtPassword.equals(msv.trim()))) {
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    if (checkBox.isChecked()) {
                        editor.putString("username", txtUserName.getText().toString());
                        editor.putString("password", txtPassword.getText().toString());
                        editor.putBoolean("checked", true);
                    } else {
                        editor.remove("username");
                        editor.remove("password");
                        editor.remove("checked");
                    }
                    editor.commit();
                } else {
                    Toast.makeText(getApplicationContext(), "Login False", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}