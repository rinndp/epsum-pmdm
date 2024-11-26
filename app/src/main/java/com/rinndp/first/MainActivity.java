package com.rinndp.first;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView welcomeText = findViewById(R.id.welcomeText);
        TextView addedText = findViewById(R.id.addedText);

        SharedPreferences preferences = getSharedPreferences("Usuario", Context.MODE_PRIVATE);
        String name = preferences.getString("name", "anonimo");
        String surname = preferences.getString("surname", "anonimo");
        String userName = preferences.getString("userName", "anonimo");

        welcomeText.setText("Hola "+name +" "+ surname);
        addedText.setText("Tu usuario es "+ userName);

        //Material 3
        Button buttonDialog = findViewById(R.id.dialogButton);
        buttonDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(MainActivity.this)
                        .setIcon(R.drawable.logo)
                        .setTitle("Hola "+ name +" "+surname)
                        .setMessage("¿Estan bien tu nombre y apellido?")
                        .setPositiveButton("Ese no es mi nombre", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Snackbar.make(view, "¿Desea cambiar su nombre?", Snackbar.LENGTH_SHORT)
                                        .setAction("Cambiar", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                LayoutInflater linf = LayoutInflater.from(MainActivity.this);
                                                final View inflator = linf.inflate(R.layout.custom_alert_dialog, null);
                                                MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(MainActivity.this)
                                                        .setIcon(R.drawable.logo)
                                                        .setTitle("Cambiar nombre")
                                                        .setView(inflator)

                                                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                EditText cambioDeNombreTexto = inflator.findViewById(R.id.cambioDeNombreTexto);
                                                                String nombreReal = cambioDeNombreTexto.getText().toString();
                                                                EditText cambioDeApellidoTexto = inflator.findViewById(R.id.cambioDeApellidoTexto);
                                                                String apelldoReal = cambioDeApellidoTexto.getText().toString();

                                                                SharedPreferences preferences = getSharedPreferences("Usuario", Context.MODE_PRIVATE);
                                                                SharedPreferences.Editor editor = preferences.edit();
                                                                editor.putString("name", nombreReal);
                                                                editor.putString("surname", apelldoReal);
                                                                welcomeText.setText("Hola "+nombreReal+" "+ apelldoReal);
                                                            }
                                                        });
                                                materialAlertDialogBuilder.show();
                                            }
                                        })
                                        .show();
                            }
                        })

                        .setNegativeButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                materialAlertDialogBuilder.show();
                }
            });


        //Material 2
        welcomeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                dialogBuilder.setMessage("holaaaaa caracolaaa"+name);
                dialogBuilder.setCancelable(true);
                dialogBuilder.setPositiveButton("Si, soy yo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                dialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();
            }
        });
    }
}