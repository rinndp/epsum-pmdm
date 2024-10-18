package com.rinndp.first;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView welcomeText = findViewById(R.id.welcomeText);
        TextView addedText = findViewById(R.id.addedText);

        SharedPreferences preferences = getSharedPreferences("Usuario", Context.MODE_PRIVATE);
        String name = preferences.getString("name", "anónimo");
        String surname = preferences.getString("surname", "anónimo");
        String userName = preferences.getString("userName", "anónimo");


        welcomeText.setText("Hola "+name +" "+ surname);
        addedText.setText("Tu usuario es "+ userName);
    }
}