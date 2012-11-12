package com.kalicinscy.step2;

import android.app.Activity;
import android.os.Bundle;
import com.kalicinscy.step2.fragments.List2Fragment;

public class List2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            List2Fragment fragment = new List2Fragment();
            Bundle arguments = new Bundle(getIntent().getExtras());
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction().add(android.R.id.content, fragment).commit();
        }
    }

}