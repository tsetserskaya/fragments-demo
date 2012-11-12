package com.kalicinscy.step1;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class List1Activity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, new Integer[]{10,20,30,40,50,60,70,80,90}));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(this, List2Activity.class);
        intent.putExtra("my_number", (Integer)l.getAdapter().getItem(position));
        startActivity(intent);
    }
}