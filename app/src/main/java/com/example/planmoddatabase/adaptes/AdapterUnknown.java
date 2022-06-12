package com.example.planmoddatabase.adaptes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.planmoddatabase.R;

import java.util.ArrayList;

public class AdapterUnknown extends BaseAdapter implements ListAdapter {

    private ArrayList<String> list = new ArrayList<String>();
    private Context context;

    public AdapterUnknown(ArrayList<String> list, Context context) {
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
            view = inflater.inflate(R.layout.row_unknown, null);
        }

        TextView planName= view.findViewById(R.id.planName);
        planName.setText(list.get(position));
        CheckBox cb= view.findViewById(R.id.btn);

        cb.setOnClickListener(v -> {
            if(cb.isChecked()) {
                //TODO mark the plan as known
                System.out.println("The plan #" + position + " is now known");
            }else{
                //TODO mark the plan as unknown
                System.out.println("The plan #" + position + " is now unknown");
            }

        });

        return view;
    }
}
