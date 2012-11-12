/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.przepisy.fragment.ifaces;

import android.app.Fragment;


/**
 *
 * @author wojtek
 */
public interface FragmentChangeListener {

    public static final int FLAG_RIGHT_FRAGMENT = 1;
    public static final int FLAG_NO_BACKSTACK = 2;
    public static final int FLAG_CLEAR_RIGHT = 4;
    public static final int FLAG_NO_BACKSTACK_ON_RIGHT = 8;
    public static final int FLAG_CLEAR_BACKSTACK = 16;

    public void onFragmentChange(Fragment fragment);

    public void onFragmentChange(Fragment fragment, int flags);
    
    public void onFragmentChange(Fragment leftFragment, Fragment rightFragment, int flags);
}
