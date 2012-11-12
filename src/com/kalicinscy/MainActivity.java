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
import pl.przepisy.fragment.ifaces.FragmentChangeListener;

public class MainActivity extends ListActivity implements FragmentChangeListener {

    
    private FrameLayout leftFrame;

    @Override
    public void onFragmentChange(Fragment leftFragment, Fragment rightFragment, int flags) {
        String backStackName = null;
        boolean addToBackStack = true;

        if ((flags & FragmentChangeListener.FLAG_CLEAR_BACKSTACK) != 0) {
            getFragmentManager().popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        if (rightFragment == null) {
            Fragment toRemove = getFragmentManager().findFragmentById(R.id.frame_right);
            if (toRemove != null) {
                transaction.remove(toRemove);
            }
        } else {
            transaction.replace(R.id.frame_right, rightFragment);
        }

        if (leftFragment == null) {
            Fragment toRemove = getFragmentManager().findFragmentById(R.id.frame);
            if (toRemove != null) {
                transaction.remove(toRemove);
            }
            leftFrame.setVisibility(View.GONE);
        } else {
            transaction.replace(R.id.frame, leftFragment);
            backStackName = "up";
            leftFrame.setVisibility(View.VISIBLE);
        }

        if ((flags & FragmentChangeListener.FLAG_NO_BACKSTACK) != 0) {
            addToBackStack = false;
        }

        if (addToBackStack) {
            transaction.addToBackStack(backStackName);
        }
        try {
            transaction.commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFragmentChange(Fragment fragment, int flags) {
        String backStackName = null;
        boolean addToBackStack = true;

        if ((flags & FragmentChangeListener.FLAG_CLEAR_BACKSTACK) != 0) {
            getFragmentManager().popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if ((flags & FragmentChangeListener.FLAG_RIGHT_FRAGMENT) != 0 && findViewById(R.id.frame_right) != null) {
            transaction.replace(R.id.frame_right, fragment);
        } else {
            transaction.replace(R.id.frame, fragment);
            backStackName = "up";
        }

        if ((flags & FragmentChangeListener.FLAG_NO_BACKSTACK) != 0) {
            addToBackStack = false;
        }

//        if ((flags & FragmentChangeListener.FLAG_NO_BACKSTACK_ON_RIGHT) != 0 && findViewById(R.id.frame_right) != null) {
//            addToBackStack = false;
//        }

        if (addToBackStack) {
            transaction.addToBackStack(backStackName);
        }
        try {
            transaction.commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFragmentChange(Fragment fragment) {
        onFragmentChange(fragment, 0);
    }

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
