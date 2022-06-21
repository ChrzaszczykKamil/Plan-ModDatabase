package com.example.planmoddatabase.adaptes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;

import com.example.planmoddatabase.R;

import java.util.ArrayList;

public class AdapterSection extends BaseAdapter implements ListAdapter {

    private final ArrayList<String> list;
    private final Context context;

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

        Item.setOnClickListener(v -> {
            //TODO: Recursive sublists loading
            System.out.println(list.get(position));
        });

        return view;
    }
}
