package com.example.app06_29;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.inputmethod.EditorInfoCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class RegistrationActivity extends AppCompatActivity {

    String[] qualification = {"10th", "12th", "Bachelor", "Masters", "Phd"};
    TextInputLayout uname, pass;
    EditText username_txt, password_txt;
    RadioGroup reg_radioGroup;
    Button btn_signUp;
    CheckBox tanC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().setTitle("Registration Form");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar aBar;
        aBar = getSupportActionBar();
        ColorDrawable cd = new ColorDrawable(Color.parseColor("#FFFFFF"));
        aBar.setBackgroundDrawable(cd);
        Spinner spinner = findViewById(R.id.spinner_qua);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.quali_arr, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);

        //Assigning ID's
        btn_signUp = findViewById(R.id.reg_signUp_btn);
        username_txt = findViewById(R.id.reg_username_text);
        password_txt = findViewById(R.id.reg_pass_text);
        uname = findViewById(R.id.uname_label);
        pass = findViewById(R.id.pass_label);
        reg_radioGroup = findViewById(R.id.radio_group_reg);
        tanC = findViewById(R.id.materialCheckBox);

        /*Switch swi_reg = (Switch) findViewById(R.id.reg_switch);
        swi_reg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(RegistrationActivity.this, "Gender : " + swi_reg.getTextOn().toString(), Toast.LENGTH_SHORT).show();
            }
        });*/

        //RadioGroup Call
        reg_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.ce_radio:
                        Toast.makeText(RegistrationActivity.this, "CE", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.it_radio:
                        Toast.makeText(RegistrationActivity.this, "IT", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.mec_radio:
                        Toast.makeText(RegistrationActivity.this, "MECHANICAL", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.ele_radio:
                        Toast.makeText(RegistrationActivity.this, "ELECTRICAL", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.civil_radio:
                        Toast.makeText(RegistrationActivity.this, "CIVIL", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        //CheckBox Call
        tanC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegistrationActivity.this, "Thankyou for accepting our T and C", Toast.LENGTH_SHORT).show();
            }
        });

        //Sign Up Button Call
        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username_txt.getText().toString();
                String pass = password_txt.getText().toString();
                if (user.isEmpty() && pass.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Username and Password\ncannot be empty", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegistrationActivity.this, "Welcome, " + user, Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Spinner Call
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), qualification[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Select something", Toast.LENGTH_SHORT).show();
            }
        });
    }
}