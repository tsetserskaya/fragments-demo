package com.kalicinscy.step3;


import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.kalicinscy.R;
import com.kalicinscy.step3.fragments.List1Fragment;

public class List1Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
                
        if (savedInstanceState == null) {
            List1Fragment fragment = new List1Fragment();
            getFragmentManager().beginTransaction().add(R.id.frame, fragment).commit();
        }
    }

}