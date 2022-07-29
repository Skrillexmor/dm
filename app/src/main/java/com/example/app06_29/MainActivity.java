package com.example.app06_29;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;
import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {
    Button btn_Cal, btn_Test, btn_reg, btn_theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        Log.d("Lifecycle", "onCreate invoked");
        //Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();

        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.CALL_PHONE}, 1);
        }

        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.INTERNET}, 1);
        }

        btn_Cal = findViewById(R.id.Call_Calculator);
        btn_Test = findViewById(R.id.Call_TestApp);
        btn_theme = findViewById(R.id.Call_DarkMode);
        btn_theme = findViewById(R.id.Call_Reg);
        btn_Cal.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CalculatorScreen.class);
            startActivity(intent);
        });

        /*btn_theme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DarkMode.class);
                startActivity(i);
            }
        });

        btn_Test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DarkMode.class);
                startActivity(i);
            }
        });

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(i);
            }
        });*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle", "onStart invoked");
        //Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle", "onStop invoked");
        //Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle", "onPause invoked");
        //Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle", "onResume invoked");
        //Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle", "onRestart invoked");
        //Toast.makeText(this, "OnRestart", Toast.LENGTH_SHORT).show();
    }

    public void taskApp(View view) {
        Intent i = new Intent(MainActivity.this, TaskAppJava.class);
        startActivity(i);
    }

    public void DarkMode(View view) {
        Intent i = new Intent(MainActivity.this, DarkMode.class);
        startActivity(i);
    }

    public void Registration(View view) {
        Intent i = new Intent(MainActivity.this, RegistrationActivity.class);
        startActivity(i);
    }

    public void tutorial_2(View view) {
        Intent i = new Intent(MainActivity.this, TutorialActivity2.class);
        startActivity(i);
    }

    public void tutorial_3(View view) {
        Intent i = new Intent(MainActivity.this, TutorialActivity3.class);
        startActivity(i);
    }

    private static final int TIME_INTERVAL = 2000;
    private long mBackPressed;

    @Override
    public void onBackPressed() {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }

        mBackPressed = System.currentTimeMillis();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, item.getTitle() + "Selected", Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.home_menu:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.help:
                //
                return true;
            case R.id.call:
                //
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void tutorial_1(View view) {
        Intent i = new Intent(MainActivity.this, TutorialActivity1.class);
        startActivity(i);
    }

    public void tutorial_4(View view) {
        Intent i = new Intent(MainActivity.this, TutorialActivity4.class);
        startActivity(i);
    }

    public void tutorial_5(View view) {
        Intent i = new Intent(MainActivity.this, TutorialActivity5.class);
        startActivity(i);
    }
}