package com.example.planmoddatabase.activities;


import static com.example.planmoddatabase.activities.MainActivity.DATABASE_MENU;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.ListView;

import com.example.planmoddatabase.R;
import com.example.planmoddatabase.adaptes.AdapterSection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DatabaseListActivity extends Activity {

    ListView myList;
    String fileName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_list);

        myList = findViewById(R.id.SectionOfTheDatabase);
        ArrayList<String> unknownPlans = new ArrayList<>();

        AssetManager am = this.getAssets();

        if(DATABASE_MENU==R.id.weapons)
        {
            System.out.println("weapons");
            fileName="weapons";
        }else if(DATABASE_MENU==R.id.armor) {
            System.out.println("armor");
            fileName="armor";
        }else if(DATABASE_MENU==R.id.pa) {
            System.out.println("pa");
            fileName="pa";
        }else if(DATABASE_MENU==R.id.camp) {
            System.out.println("camp");
            fileName="camp";
        }else if(DATABASE_MENU==R.id.chemistry) {
            System.out.println("chemistry");
            fileName="chemistry";
        }else if(DATABASE_MENU==R.id.cook) {
            System.out.println("cook");
            fileName="cook";
        }else if(DATABASE_MENU==R.id.tinkers) {
            System.out.println("tinkers");
            fileName="tinkers";
        }else if(DATABASE_MENU==R.id.brewing) {
            System.out.println("brewing");
            fileName="brewing";
        }else if(DATABASE_MENU==R.id.photomode) {
            System.out.println("photomode");
            fileName="photomode";
        }

        try {
            InputStream is = am.open(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;

            while ((line = reader.readLine()) != null)
                unknownPlans.add(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(DATABASE_MENU);

        myList.setAdapter(new AdapterSection(unknownPlans, this));

        /*
        this thing will be useful
        val firstAdapter: FirstAdapter = ;
        val secondAdapter: SecondAdapter = ;
        val thirdAdapter: ThirdAdapter = ;
        val concatAdapter = ConcatAdapter(firstAdapter, secondAdapter, thirdAdapter);
        recyclerView.adapter = concatAdapter;*/
    }
}