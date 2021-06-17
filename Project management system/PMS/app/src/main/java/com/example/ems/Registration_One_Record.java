package com.example.ems;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Registration_One_Record extends AppCompatActivity {
    TextView name , sureName , age , cnic , event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_registration_one_record);


        Bundle bundel = getIntent().getExtras();
        String id = bundel.getString("id");

        RegistrationDBHelper resourceApplicationDBHelper = new RegistrationDBHelper(Registration_One_Record.this);
        Registration registration = resourceApplicationDBHelper.getData(Integer.parseInt(id));

        name = findViewById(R.id.First_Name);
        name.setText(registration.getName());

        sureName = findViewById(R.id.Sure_Name);
        sureName.setText(registration.getPh_no());

        age = findViewById(R.id.AgE);
        age.setText(registration.getCNIC());

        cnic = findViewById(R.id.CniC);
        cnic.setText(registration.getStatus());

        event = findViewById(R.id.EveNt);
        event.setText(registration.getProject());




    }
}