package org.mdsd2016.android.dummyfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    private TextView mTxtViewInfo;
    private double mExternalRandomNumber;


    public SecondFragment() {
        // Required empty public constructor
    }

    public SecondFragment(double randomNumber) {

        if(randomNumber != 0.0) {
            this.mExternalRandomNumber = randomNumber;
        }

}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View rootView = inflater.inflate(R.layout.fragment_second, container, false);
        this.mTxtViewInfo = (TextView) rootView.findViewById(R.id.tv_info_second_fragment);

        if (this.mExternalRandomNumber != 0.0){
            this.updateTextView(mExternalRandomNumber);
        }

        return rootView;

    }

    public void updateTextView(double randomNumber) { //prototype created here from MainActivity getRandomNumber() class

            this.mTxtViewInfo.setText(String.valueOf(randomNumber));

    }
}
