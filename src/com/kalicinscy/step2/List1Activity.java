package com.kalicinscy.step2;

import android.app.Activity;
import android.os.Bundle;
import com.kalicinscy.step2.fragments.List1Fragment;

public class List1Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            List1Fragment fragment = new List1Fragment();
            getFragmentManager().beginTransaction().add(android.R.id.content, fragment).commit();
        }
    }

}