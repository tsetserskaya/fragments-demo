package com.kalicinscy.step3.fragments;

import com.kalicinscy.step2.fragments.*;
import android.app.ListActivity;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.kalicinscy.step3.NumberActivity;

public class List2Fragment extends ListFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Integer myNumber =  getArguments().getInt("my_number", 0);
        
        Integer[] numbers = new Integer[]{
            myNumber + 0,
            myNumber + 1,
            myNumber + 2,
            myNumber + 3,
            myNumber + 4,
            myNumber + 5,
            myNumber + 6,
            myNumber + 7,
            myNumber + 8,
            myNumber + 9
        };
        
        setListAdapter(new ArrayAdapter(getActivity(), android.R.layout.two_line_list_item, android.R.id.text1, numbers){

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);
                int num = (Integer)getItem(position);
                ((TextView)v.findViewById(android.R.id.text2)).setText(String.format("Czyli liczba znajdująca się pomiędzy %d i %d", num - 1, num + 1));
                return v;
            }
            
        });
    }
    
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(getActivity(), NumberActivity.class);
        intent.putExtra("my_number", (Integer)l.getAdapter().getItem(position));
        startActivity(intent);
    }
}