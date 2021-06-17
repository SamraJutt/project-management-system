package com.example.ems;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Registration_List_Activity extends AppCompatActivity {

    List<Resourec_application> resourecapplicationList = new ArrayList<>();
    ListView hallSpinner;
    Button addbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resource_application_list_activity);


        ResoureceDBHelper resoureceDBHelper = new ResoureceDBHelper(Resource_Application_List_Activity.this);
        resourecapplicationList = resoureceDBHelper.getAllHalls();

        hallSpinner = findViewById(R.id.Halls);

//        Log.i("MYTAG" , eventList.get(0).getTitle());


        Resourece_ApplicationAdapter resoureceApplicationAdapter = new Resourece_ApplicationAdapter(resourecapplicationList);

        hallSpinner.setAdapter(resoureceApplicationAdapter);

        addbtn = findViewById(R.id.addHallbtn);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newActivity = new Intent( Resource_Application_List_Activity.this , Resource_Applicationl_view_Activity.class);
                startActivity(newActivity);

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        ResoureceDBHelper resoureceDBHelper = new ResoureceDBHelper(Resource_Application_List_Activity.this);
        Log.i("MY HALL" , "Resumed");
        resourecapplicationList = resoureceDBHelper.getAllHalls();

        hallSpinner = findViewById(R.id.Halls);

//        Log.i("MYTAG" , eventList.get(0).getTitle());


        Resourece_ApplicationAdapter resoureceApplicationAdapter = new Resourece_ApplicationAdapter(resourecapplicationList);
        Log.i("MY HALL" , String.valueOf(resoureceApplicationAdapter.getCount()));

        hallSpinner.setAdapter(resoureceApplicationAdapter);

    }
}