package com.example.ems;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Registration_list_activity extends AppCompatActivity {


    List<Registration> registrationList = new ArrayList<>();
    ListView partiSpinner;
    Button addbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_registration_list_activity);


        RegistrationDBHelper resourceApplicationDBHelper = new RegistrationDBHelper(Registration_list_activity.this);
        registrationList = resourceApplicationDBHelper.getAllApplicants();

        partiSpinner = findViewById(R.id.Particpents);

//        Log.i("MYTAG" , eventList.get(0).getTitle());


        RegistartionAdapter registartionAdapter = new RegistartionAdapter(registrationList);

        partiSpinner.setAdapter(registartionAdapter);

        addbtn = findViewById(R.id.addPartbtn);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newActivity = new Intent( Registration_list_activity.this , Resource_view_activity.class);
                startActivity(newActivity);

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        RegistrationDBHelper resourceApplicationDBHelper = new RegistrationDBHelper(Registration_list_activity.this);
        Log.i("MY Participents" , "Resumed");
        registrationList = resourceApplicationDBHelper.getAllApplicants();

        partiSpinner = findViewById(R.id.Particpents);

//        Log.i("MYTAG" , eventList.get(0).getTitle());


        partiSpinner = findViewById(R.id.Particpents);

//        Log.i("MYTAG" , eventList.get(0).getTitle());


        RegistartionAdapter registartionAdapter = new RegistartionAdapter(registrationList);

        partiSpinner.setAdapter(registartionAdapter);

    }
}