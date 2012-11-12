package com.kalicinscy.fragment;

import android.app.Fragment;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kalicinscy.R;


/**
 *
 * @author wojtek
 */
public class DictionaryFragment extends Fragment {

    private long dictId;

    public void setDictId(long dictId) { 
        Bundle b = new Bundle();
        b.putLong("id", dictId);
        setArguments(b);
        this.dictId = dictId;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dictId = getArguments().getLong("id");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tip_view, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

//    @Override
//    public void onStart() {
//        super.onResume();
//        getLoaderManager().restartLoader(0, null, this);
//    }
    
    
//    @Override
//    public void onLoadFinished(Loader<Cursor> loader, Cursor c) {
//        if (c.moveToNext()) {
//            ((TextView) getView().findViewById(R.id.tip_name)).setText(c.getString(c.getColumnIndex("word")));
//            ((TextView) getView().findViewById(R.id.tip_body)).setText(c.getString(c.getColumnIndex("body")));
//        }
//    }

}
