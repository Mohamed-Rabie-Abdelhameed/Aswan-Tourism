package com.example.aswantourism;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context context;
    ArrayList<Place> places;

    public MyAdapter(Context context, ArrayList<Place> places){
        this.context = context;
        this.places=places;
    }

    @Override
    public int getCount() {
        return places.size();
    }

    @Override
    public Object getItem(int i) {
        return places.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if(v==null){
            v = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, null, false);
        }
        TextView tv = v.findViewById(android.R.id.text1);
        String name = places.get(i).getName();
        tv.setText(name);
        tv.setTextSize(20);
        return v;
    }
}
