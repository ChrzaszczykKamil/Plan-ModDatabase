package com.example.planmoddatabase.activities;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.planmoddatabase.R;
import com.example.planmoddatabase.adaptes.AdapterSection;

import java.util.ArrayList;

public class DatabaseListActivity extends Activity {

    ListView myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_list);

        myList = findViewById(R.id.SectionOfTheDatabase);

        ArrayList<String> unknownPlans = new ArrayList<>();
        //this should be removed
        unknownPlans.add("TEMP1");
        unknownPlans.add("TEMP2");
        unknownPlans.add("TEMP3");
        unknownPlans.add("TEMP4");
        unknownPlans.add("TEMP5");
        unknownPlans.add("TEMP6");
        unknownPlans.add("TEMP7");
        unknownPlans.add("TEMP8");
        unknownPlans.add("TEMP9");
        unknownPlans.add("TEMP10");
        unknownPlans.add("TEMP11");
        unknownPlans.add("TEMP12");
        unknownPlans.add("TEMP13");
        unknownPlans.add("TEMP14");
        unknownPlans.add("TEMP15");
        unknownPlans.add("TEMP16");
        unknownPlans.add("TEMP17");
        unknownPlans.add("TEMP18");
        unknownPlans.add("TEMP19");
        unknownPlans.add("TEMP20");

        myList.setAdapter(new AdapterSection(unknownPlans, this));
    }
}