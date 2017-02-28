package org.mdsd2016.android.dummyfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment { //plain Java. Means that we are using an import in the project which is above (in the imports)
    //comes from the v4 support library. Means that fragments were added later.  Important because sometimes you instantiate fragments
    //but import is not Android.support. library. When you are trying to add libraries, even being called fragments it crashes.
    //problem with Fragments = at one pt. you might have runtme errors that are not well documented.
    //


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);

        //returns a view object. Inflate instance was done in the menu manager. Reference to R.layout

    }

}
