package com.example.app06_29;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class TaskAppJava extends AppCompatActivity {
    Button btn;
    EditText txt;
    TextInputLayout body_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_app);
        getSupportActionBar().setTitle("Task App");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar aBar;
        aBar= getSupportActionBar();
        ColorDrawable cd = new ColorDrawable(Color.parseColor("#FFFFFF"));
        aBar.setBackgroundDrawable(cd);
        btn = findViewById(R.id.createUserButton);
        txt = findViewById(R.id.username);
        body_txt = findViewById(R.id.body);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = txt.getText().toString();
                if (!validateData()) {
                    return;
                }
                Toast.makeText(TaskAppJava.this, "User " + s + " created.", Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean validateData() {
        String val = Objects.requireNonNull(body_txt.getEditText()).getText().toString().trim();

        if (val.isEmpty()) {
            body_txt.setError("Field cannot be empty");
            return false;
        } else if (val.length() > 20) {
            body_txt.setError("You have reached character limit");
            return false;
        } else {
            body_txt.setError(null);
            body_txt.setErrorEnabled(false);
            return true;
        }

    }
}