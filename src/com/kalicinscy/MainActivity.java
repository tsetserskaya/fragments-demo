package com.kalicinscy;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.kalicinscy.step1.List1Activity;

public class MainActivity extends ListActivity {

    
    private FrameLayout leftFrame;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if (!getResources().getBoolean(R.bool.is600dp)) {
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
//        }
//        
//        setContentView(R.layout.main);
//
//        leftFrame = (FrameLayout) findViewById(R.id.frame);
        setListAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, new Class[]{
            com.kalicinscy.step1.List1Activity.class,
            com.kalicinscy.step2.List1Activity.class,
            com.kalicinscy.step3.List1Activity.class
        }));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        startActivity(new Intent(this, (Class)l.getItemAtPosition(position)));
    }
}
