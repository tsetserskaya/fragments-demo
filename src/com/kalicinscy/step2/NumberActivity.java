package com.kalicinscy.step2;

import com.kalicinscy.step1.*;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.kalicinscy.R;

public class NumberActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Integer myNumber = getIntent().getIntExtra("my_number", 0);
        setContentView(R.layout.number_view);
        
        ((TextView)findViewById(R.id.number)).setText(String.valueOf(myNumber));
        ((TextView)findViewById(R.id.description)).setText(String.format("Czyli liczba znajdująca się pomiędzy %d i %d", myNumber - 1, myNumber + 1));
    }

}