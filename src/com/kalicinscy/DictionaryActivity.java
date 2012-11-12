package com.kalicinscy;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.kalicinscy.fragment.DictionaryFragment;

public class DictionaryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!getResources().getBoolean(R.bool.is600dp)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        }

        if (savedInstanceState == null) {
            DictionaryFragment fragment = new DictionaryFragment();
            fragment.setDictId(getIntent().getLongExtra("id", 0));
            getFragmentManager().beginTransaction().add(android.R.id.content, fragment).commit();
        }
    }
    
    
}