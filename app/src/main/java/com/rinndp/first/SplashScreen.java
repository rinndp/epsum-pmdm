package com.rinndp.first;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Animation gradientColour = AnimationUtils.loadAnimation(this, R.anim.gradient_colour);
        ImageView splashLogo = findViewById(R.id.splashLogo);
        TextView splashAppAnme = findViewById(R.id.splashAppName);
        splashLogo.startAnimation(gradientColour);
        splashAppAnme.startAnimation(gradientColour);

        ImageView glideBackground = findViewById(R.id.splashGlideBackground);

        Glide.with(this)
                .load("https://images.unsplash.com/photo-1665162848578-6fefca8e76d1?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
                .transition(DrawableTransitionOptions.withCrossFade(1000))
                .centerCrop()
                .into(glideBackground);
    }
}