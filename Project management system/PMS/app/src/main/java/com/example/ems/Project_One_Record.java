package com.example.ems;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Project_One_Record extends AppCompatActivity {

    TextView title , mng, date , desc , budget, type, status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_one__record);

        Bundle bundel = getIntent().getExtras();
        String id = bundel.getString("id");

        ProjectDBHelper projectDbHelper = new ProjectDBHelper(Project_One_Record.this);
        Project project = projectDbHelper.getData(Integer.parseInt(id));

        title = findViewById(R.id.view_title);
        title.setText(project.getTitle());

        mng = findViewById(R.id.view_org);
        mng.setText(project.getManager());

        date = findViewById(R.id.view_date);
        date.setText(project.getDate());

        desc = findViewById(R.id.view_desc);
        desc.setText(project.getDescription());

        budget = findViewById(R.id.view_limit);
        budget.setText(project.getBudget());

        type = findViewById(R.id.view_budget);
        type.setText(project.getType());

        status = findViewById(R.id.view_event);
        status.setText(project.getStatus());


    }
}