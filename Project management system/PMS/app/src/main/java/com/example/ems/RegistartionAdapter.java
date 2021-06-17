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

public class RegistartionAdapter extends BaseAdapter {

    public RegistartionAdapter(List<Registration> registrationList) {
        this.registrationList = registrationList;
    }

    List<Registration> registrationList;
    @Override
    public int getCount() {
        return 0;
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

        String id = registrationList.get(position).getId();
        Bundle bundle = new Bundle();
        bundle.putString("id" , id);

        LayoutInflater layout = LayoutInflater.from(parent.getContext());
        View view = layout.inflate(R.layout.user_regstration_list, parent , false);
        ((TextView) view.findViewById(R.id.participent_txt)).setText(registrationList.get(position).getName()+"  "+ registrationList.get(position).getPh_no());


        Button Read , Update , Delete;

        // Binding View Button
        Read= view.findViewById(R.id.parti_view_btn);
        Read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, Resource_view_activity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        Update = view.findViewById(R.id.parti_update_btn);
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context context = v.getContext();
                Intent intent = new Intent(context, Resource_view_activity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });

        if(position >=0) {
            Delete = view.findViewById(R.id.parti_del_btn);
            Delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("EVENT", "DELETING");
                    Context context = v.getContext();
                    RegistrationDBHelper resourceApplicationDBHelper = new RegistrationDBHelper(context);
                    if (resourceApplicationDBHelper.deleteApplicant(Integer.parseInt(id)) != 0) {
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
        registrationList.remove(position);
        notifyDataSetChanged();
    }

}
