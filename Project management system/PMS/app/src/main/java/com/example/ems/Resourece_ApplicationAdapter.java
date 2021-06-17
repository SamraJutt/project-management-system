package com.example.ems;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Resourece_ApplicationAdapter extends BaseAdapter {
    List<Resourec_application> resourecapplicationList;

    public Resourece_ApplicationAdapter(List<Resourec_application> resourecapplicationList) {
        Log.i("MY HALL" , "ADAPTER ADDED");
        this.resourecapplicationList = resourecapplicationList;
    }

    @Override
    public int getCount() {
        return resourecapplicationList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String id = resourecapplicationList.get(position).getId();
        Bundle bundle = new Bundle();
        bundle.putString("id" , id);


        LayoutInflater layout = LayoutInflater.from(parent.getContext());
        View view = layout.inflate(R.layout.resource_application_list, parent , false);
        ((TextView) view.findViewById(R.id.hall_list_view)).setText(resourecapplicationList.get(position).getHallName()+" : "+ resourecapplicationList.get(position).getLocation());

        Button Read , Update , Delete;

        // Binding View Button
        Read= view.findViewById(R.id.hallViewBtn);
        Read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, One_Resource_Application_Activity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        Update = view.findViewById(R.id.hallUpdateBtn);
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context context = v.getContext();
                Intent intent = new Intent(context, Resource_Applicationl_view_Activity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });

        if(position >=0) {
            Delete = view.findViewById(R.id.hallDeleteBtn);
            Delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("EVENT", "DELETING");
                    Context context = v.getContext();
                    ResoureceDBHelper resoureceDBHelper = new ResoureceDBHelper(context);
                    if (resoureceDBHelper.deleteHall(Integer.parseInt(id)) != 0) {
                        removeViewAt(position);
                    } else {
                        Log.i("EVENT", "DELETION FAILED");
                    }
                }
            });
        }


        return view;
    }

    public void removeViewAt(int position){
        resourecapplicationList.remove(position);
        notifyDataSetChanged();
    }

}
