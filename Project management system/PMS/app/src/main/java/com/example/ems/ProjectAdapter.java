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

public class ProjectAdapter extends BaseAdapter {

    List<Project> projectList;

    public ProjectAdapter(List<Project> projectList) {
        this.projectList = projectList;
    }

    @Override
    public int getCount() {
        return projectList.size();
    }


    @Override
    public Object getItem(int position) {
        return projectList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //View v = convertView;

        Log.i("EVENT" , projectList.get(position).getId());
        String id = projectList.get(position).getId();
        Bundle  bundle = new Bundle();
        bundle.putString("id" , id);



        LayoutInflater layout = LayoutInflater.from(parent.getContext());
        View view = layout.inflate(R.layout.projectlist, parent , false);
        ((TextView) view.findViewById(R.id.txt1)).setText(projectList.get(position).getTitle()+" by "+ projectList.get(position).getManager());

        Button Read , Update , Delete;

        // Binding View Button
        Read= view.findViewById(R.id.btnview);
        Read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, Project_One_Record.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        Update = view.findViewById(R.id.uptbtn);
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context context = v.getContext();
                Intent intent = new Intent(context, Project_view_Activity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });

        if(position >=0) {
            Delete = view.findViewById(R.id.delbtn);
            Delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("EVENT", "DELETING");
                    Context context = v.getContext();
                    ProjectDBHelper projectDbHelper = new ProjectDBHelper(context);
                    if (projectDbHelper.deleteProject(Integer.parseInt(id)) != 0) {
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
        projectList.remove(position);
        notifyDataSetChanged();
    }

}
