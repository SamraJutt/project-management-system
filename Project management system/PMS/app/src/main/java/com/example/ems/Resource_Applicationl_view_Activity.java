package com.example.ems;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Resource_Applicationl_view_Activity extends AppCompatActivity {

    TextView hallName , capacity , floor , rent , location;
    Button finishbtn;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resource_application_view_activity);

        hallName = findViewById(R.id.HallName);
        capacity = findViewById(R.id.HallCapacity);
        floor = findViewById(R.id.floors);
        rent = findViewById(R.id.Rent);
        location = findViewById(R.id.location);

        finishbtn = findViewById(R.id.hallAddAndUpdateBtn);

        if(getIntent().getExtras() != null){
            Log.i("EVENT" , "UPDATION STEP");

            Bundle bundel = getIntent().getExtras();
            id = bundel.getString("id");

            ResoureceDBHelper resoureceDBHelper = new ResoureceDBHelper(Resource_Applicationl_view_Activity.this);
            Resourec_application resourecapplication = resoureceDBHelper.getData(Integer.parseInt(id));

            capacity.setText(resourecapplication.getCapacity());
            hallName.setText(resourecapplication.getHallName());
            floor.setText(resourecapplication.getFloor());

            rent.setText(resourecapplication.getRent());
            location.setText(resourecapplication.getLocation());

        }


        finishbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = hallName.getText().toString();
                String Capacity = capacity.getText().toString();
                String Floor = floor.getText().toString();
                String Rent = rent.getText().toString();
                String Location = location.getText().toString();
                if(Name.isEmpty()){
                    ToastShow("Hall Name");
                }
                else if(Capacity.isEmpty()){
                    ToastShow("Capacity");
                }
                else if(Floor.isEmpty()){
                    ToastShow(" Floors ");
                }
                else if(Rent.isEmpty()){
                    ToastShow("Rent");
                }
                else if(Location.isEmpty()){
                    ToastShow("Location");
                }

                ResoureceDBHelper resoureceDBHelper = new ResoureceDBHelper(Resource_Applicationl_view_Activity.this);
                if(getIntent().getExtras() != null ){

                    if(resoureceDBHelper.updateHall(Integer.parseInt(id)  , Name , Capacity , Floor , Rent , Location ))
                    {
                        Log.i("HALL" , "UPDATED");
                    }
                    else{
                        Log.i("HALL" , "UPDATION FAILED");
                    }

                }
                else {
                    if (resoureceDBHelper.insertHall(Name , Capacity , Floor , Rent , Location)) {
                        Log.i("Hall", "Hall Added");
                    }
                    else{
                        Log.i("Hall", "Hall Addition Failed");
                    }

            }

        }


        });


    }
    public void ToastShow(String field){
        Log.i("MYTAG" ,    "` `");
        Toast.makeText(this , field+" is required",Toast.LENGTH_LONG).show();
        Log.i("MYTAG" ,    "` `");
    }

}