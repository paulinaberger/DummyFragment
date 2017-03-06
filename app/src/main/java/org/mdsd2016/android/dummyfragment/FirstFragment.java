package org.mdsd2016.android.dummyfragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment  { //plain Java. Means that we are using an import in the project which is above (in the imports)
    //comes from the v4 support library. Means that fragments were added later.  Important because sometimes you instantiate fragments
    //but import is not Android.support. library. When you are trying to add libraries, even being called fragments it crashes.
    //problem with Fragments = at one pt. you might have runtme errors that are not well documented.
    //

    public interface ICom2Activity {
        public void getRandomNumberFromFragment1(); //abstract so no content just close with ;
    }

    private ICom2Activity mInterfaceInstance;

    private final static String TAG = FirstFragment.class.getSimpleName();


    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.mInterfaceInstance = (ICom2Activity) context;
        } catch (ClassCastException e){
            Log.e(FirstFragment.TAG, "Error on Something");

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        //returns a view object. Inflate instance was done in the menu manager. Reference to R.layout
        //(assigning view to local variable) // in fragrments we need rootView

        final Button btnUpdateFrag2 = (Button) rootView.findViewById(R.id.btn_update_fragment2_first_fragment);
        btnUpdateFrag2.setOnClickListener(new View.OnClickListener() {


            @Override
                    public void onClick (View whichView){

                Log.i(FirstFragment.TAG, "Button Clicked");

                if (mInterfaceInstance !=null) {
                    mInterfaceInstance.getRandomNumberFromFragment1();
                }
                }
              //  ((MainActivity) getActivity()).getRandomNumberFromFragment1();
        });

        return rootView;
    }
}
