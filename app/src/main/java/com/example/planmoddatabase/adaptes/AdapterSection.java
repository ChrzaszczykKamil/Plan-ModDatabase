package com.example.planmoddatabase.adaptes;

import static com.example.planmoddatabase.activities.DatabaseListActivity.fileName;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.planmoddatabase.R;
import com.example.planmoddatabase.activities.DatabaseListActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AdapterSection extends BaseAdapter implements ListAdapter {

    private ArrayList<String> list;
    private final Context context;
    DatabaseListActivity parentActivity;

    public AdapterSection(ArrayList<String> list, Context context, DatabaseListActivity parentActivity) {
        this.list = list;
        this.context = context;
        this.parentActivity=parentActivity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
        //return list.get(pos).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view = convertView;
        String[] listEntry = list.get(position).split(" ", 2);
        if(listEntry[0].equals("--")) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row_dropdown_menu, null);

            Button Item = view.findViewById(R.id.itemX);
            Item.setText(listEntry[1].split(" ", 2)[1]);

            Item.setOnClickListener(v -> {
                ArrayList<String> unknownPlans = new ArrayList<>();
                fileName+="Sub/"+listEntry[1].split(" ", 2)[0];
                try {
                    InputStream is = context.getAssets().open(fileName);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    String line;

                    while ((line = reader.readLine()) != null) {
                        unknownPlans.add(line);
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //TODO: Recursive sublists loading
                list =unknownPlans;
                parentActivity.setTitle(unknownPlans.get(0));
                list.remove(0);
                notifyDataSetChanged();

                System.out.println("opening"+fileName);
            });
        }else if(listEntry[0].equals("..")) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row_unknown, null);
            TextView planName= view.findViewById(R.id.planName);
            planName.setText(listEntry[1]);
        }else if(listEntry[0].equals("++")) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row_unknown, null);
            TextView planName= view.findViewById(R.id.planName);
            planName.setText("BASE "+listEntry[1]);
        }else if(listEntry[0].equals("||")) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row_unknown, null);
            TextView planName= view.findViewById(R.id.planName);
            planName.setText("--"+listEntry[1]);
        }

        return view;
    }
}
