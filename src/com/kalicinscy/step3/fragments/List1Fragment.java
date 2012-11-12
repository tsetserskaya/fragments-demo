package com.kalicinscy.step3.fragments;

import android.app.FragmentTransaction;
import com.kalicinscy.step2.fragments.*;
import android.app.ListActivity;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.kalicinscy.R;
import com.kalicinscy.step2.List2Activity;

public class List1Fragment extends ListFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, new Integer[]{10,20,30,40,50,60,70,80,90}));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        int myNumber = (Integer)l.getAdapter().getItem(position);
        if (getActivity().findViewById(R.id.frame_right) != null){
            FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();
            Bundle args = new Bundle();
            args.putInt("my_number", myNumber);
            List2Fragment fragment = new List2Fragment();
            fragment.setArguments(args);
            ft.replace(R.id.frame_right, fragment);
            ft.commit();
        } else {
            Intent intent = new Intent(getActivity(), List2Activity.class);
            intent.putExtra("my_number", myNumber);
            startActivity(intent);
        }
        
    }
    
}