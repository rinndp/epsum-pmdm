package com.rinndp.first;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        TextInputLayout registerNameTIL = findViewById(R.id.registerNameTIL);
        TextInputLayout registerSurenameTIL = findViewById(R.id.registerSurnameTIL);
        TextInputLayout registerUsernameTIL = findViewById(R.id.registerUsernameTIL);
        TextInputLayout registerPasswordTIL = findViewById(R.id.registerPasswordTIL);
        TextInputLayout registerConfirmPasswordTIL = findViewById(R.id.registerConfirmPasswordTIL);

        Button registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = String.valueOf(registerNameTIL.getEditText().getText());
                String surname = String.valueOf(registerSurenameTIL.getEditText().getText());
                String userName = String.valueOf(registerUsernameTIL.getEditText().getText());
                String userPassword = String.valueOf(registerPasswordTIL.getEditText().getText());
                String userConfirmPassword = String.valueOf(registerConfirmPasswordTIL.getEditText().getText());

                if (!userPassword.equals(userConfirmPassword)) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Tus contraseñas NO coinciden", Toast.LENGTH_SHORT);
                    toast.show();
                } else if (userName.equals(null)) {
                        Toast toast = Toast.makeText(getApplicationContext(), "El nombre NO puede ser nulo", Toast.LENGTH_SHORT);
                        toast.show();
                } else if (surname.equals(null)) {
                    Toast toast = Toast.makeText(getApplicationContext(), "El apellido NO puede ser nulo", Toast.LENGTH_SHORT);
                    toast.show();

                } else if (userName.equals(null)) {
                    Toast toast = Toast.makeText(getApplicationContext(), "El usuario NO puede ser nulo", Toast.LENGTH_SHORT);
                    toast.show();
                    
                } else {
                    SharedPreferences preferences = getSharedPreferences("Usuario", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("name", name);
                    editor.putString("surname", surname);
                    editor.putString("userName", userName);
                    editor.putString("password", userPassword);

                    editor.apply();
                    launchMain();

                }
            }
        });
    }
    public void launchMain() {
        Intent intent = new Intent(Register.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}
