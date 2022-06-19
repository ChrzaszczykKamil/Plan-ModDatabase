package com.example.planmoddatabase.adaptes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.planmoddatabase.R;

import java.util.ArrayList;

public class AdapterSection extends BaseAdapter implements ListAdapter {

    private final ArrayList<String> list;
    private final Context context;
    ArrayList<String> unknownPlans = new ArrayList<>();


    public AdapterSection(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
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
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row_dropdown_menu, null);
        }

        Button Item= view.findViewById(R.id.itemX);
        Item.setText(list.get(position));

        ListView myList;
        myList = view.findViewById(R.id.sublist);
        //This thing should expand a sublist of buttons when clicked but for some reason I can't use
        //adapter inside an adapter
        Item.setOnClickListener(v -> {


            System.out.println("expand list");
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
            unknownPlans.add("TEMP18");
            unknownPlans.add("TEMP19");
            unknownPlans.add("TEMP20");
        });
        unknownPlans.add("TEMP18");
        unknownPlans.add("TEMP19");
        unknownPlans.add("TEMP20");
        ArrayAdapter<String> adapter=new ArrayAdapter<>(
                parent.getContext(),
                android.R.layout.simple_list_item_1,
                unknownPlans
        );
        myList.setAdapter(adapter);

        return view;
    }
}
