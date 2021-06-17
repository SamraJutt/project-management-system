package com.example.ems;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class One_Resource_Application_Activity extends AppCompatActivity {

    TextView hallName , capacity , rent , floor , location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_resource_application_layout);


        Bundle bundel = getIntent().getExtras();
        String id = bundel.getString("id");

        ResoureceDBHelper resoureceDBHelper = new ResoureceDBHelper(One_Resource_Application_Activity.this);
        Resourec_application resourecapplication = resoureceDBHelper.getData(Integer.parseInt(id));

        hallName = findViewById(R.id.Hall_Name);
        hallName.setText(resourecapplication.getHallName());

        capacity = findViewById(R.id.hall_capacity);
        capacity.setText(resourecapplication.getCapacity());

        rent = findViewById(R.id.hall_rent);
        rent.setText(resourecapplication.getRent());

        floor = findViewById(R.id.hall_floors);
        floor.setText(resourecapplication.getFloor());

        location = findViewById(R.id.hall_location);
        location.setText(resourecapplication.getLocation());

    }

}