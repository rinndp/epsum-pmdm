package com.rinndp.first;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.textfield.TextInputLayout;
import io.github.muddz.styleabletoast.StyleableToast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        Button loginButton = findViewById(R.id.loginButtonLogin);
        Button loginRegisterButton = findViewById(R.id.loginSignButton);

        TextInputLayout loginUserName = findViewById(R.id.loginUsernameTIL);
        TextInputLayout loginPassword = findViewById(R.id.loginPasswordTIL);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = String.valueOf(loginUserName.getEditText().getText());
                String password = String.valueOf(loginPassword.getEditText().getText());

                SharedPreferences sharedPreferences = getSharedPreferences("Usuario", Context.MODE_PRIVATE);

                String registeredUserName = sharedPreferences.getString("userName", "anonimo");
                String registeredPassword = sharedPreferences.getString("userPassword", "anonimo");
                if (!userName.equals(registeredUserName) || !password.equals(registeredPassword)) {
                    StyleableToast loginToast = StyleableToast.makeText(getApplicationContext(), "El usuario o la contraseña NO son correctos", R.style.toastError);
                    loginToast.show();
                } else {
                    launchMain();
                }
            }
        });

        loginRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchRegister();
            }
        });
    }

    public void launchMain() {
        Intent intent = new Intent(Login.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void launchRegister() {
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }
}