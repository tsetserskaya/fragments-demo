/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kalicinscy.fragment;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.kalicinscy.DictionaryActivity;

/**
 *
 * @author wojtek
 */
public class DictionaryListFragment extends ListFragment {

    
    public void setLetters(String from, String to) {
        Bundle b = new Bundle();
//        b.putString("listType", ListType.LETTER.name());
        b.putString("from", from);
        b.putString("to", to);
        setArguments(b);
    }

    public void setType(int type) {
        Bundle b = new Bundle();
//        b.putString("listType", ListType.TYPE.name());
        b.putInt("type", type);
        setArguments(b);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        getListView().setFastScrollEnabled(true);
    }

    @Override
    public void onListItemClick(ListView l, View v, final int position, long id) {
        Intent intent = new Intent(getActivity(), DictionaryActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

}
