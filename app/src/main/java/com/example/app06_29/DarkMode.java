package com.example.app06_29;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DarkMode extends AppCompatActivity {
    Button btn_light, btn_dark;
    TextView label;
    ConstraintLayout body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dark_mode);
        getSupportActionBar().setTitle("Theme's App");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar aBar;
        aBar = getSupportActionBar();
        ColorDrawable cd = new ColorDrawable(Color.parseColor("#FFFFFF"));
        aBar.setBackgroundDrawable(cd);
        btn_light = findViewById(R.id.Call_Light);
        btn_dark = findViewById(R.id.Call_Dark);
        body = findViewById(R.id.main_theme);
        label = findViewById(R.id.tv1);

        btn_light.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                /* or getSupportActionBar() */
                getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                getWindow().setStatusBarColor(ContextCompat.getColor(DarkMode.this,R.color.white));
                getWindow().setNavigationBarDividerColor(Color.rgb(255, 255, 255));
                getWindow().setNavigationBarColor(Color.rgb(255, 255, 255));
                getWindow().setTitleColor(Color.rgb(64, 64, 64));
                ActionBar aBar;
                aBar = getSupportActionBar();
                ColorDrawable cd = new ColorDrawable(Color.parseColor("#FFFFFF"));
                aBar.setBackgroundDrawable(cd);
                body.setBackgroundResource(R.color.white);
                label.setTextColor(Color.rgb(64, 64, 64));
                btn_dark.setTextColor(Color.rgb(255, 255, 255));
                btn_light.setTextColor(Color.rgb(255, 255, 255));
                Toast.makeText(DarkMode.this, "Light Mode", Toast.LENGTH_SHORT).show();
            }
        });

        btn_dark.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\">" + getString(R.string.Darkmodename) + "</font>"));
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setHomeAsUpIndicator(R.drawable.light_back);
                getWindow().setStatusBarColor(ContextCompat.getColor(DarkMode.this, R.color.black));
                View decorView = getWindow().getDecorView(); //set status background black
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                getWindow().setNavigationBarDividerColor(Color.rgb(64, 64, 64));
                getWindow().setNavigationBarColor(Color.rgb(64, 64, 64));
                ActionBar aBar;
                aBar = getSupportActionBar();
                ColorDrawable cd = new ColorDrawable(Color.parseColor("#404040"));
                aBar.setBackgroundDrawable(cd);
                body.setBackgroundResource(R.color.black);
                label.setTextColor(Color.rgb(255, 255, 255));
                btn_dark.setTextColor(Color.rgb(64, 64, 64));
                btn_light.setTextColor(Color.rgb(64, 64, 64));
                Toast.makeText(DarkMode.this, "Dark Mode", Toast.LENGTH_SHORT).show();
            }
        });
    }
}