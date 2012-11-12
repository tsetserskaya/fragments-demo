package com.kalicinscy;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import com.kalicinscy.fragment.DictionaryListFragment;
import android.os.Bundle;

public class DictionaryListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!getResources().getBoolean(R.bool.is600dp)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        }
        if (savedInstanceState == null) {
            DictionaryListFragment fragment = new DictionaryListFragment();
//			fragment.setRecipeId(getIntent().getLongExtra("id", 0));
            getFragmentManager().beginTransaction().add(android.R.id.content, fragment).commit();
        }
    }
}