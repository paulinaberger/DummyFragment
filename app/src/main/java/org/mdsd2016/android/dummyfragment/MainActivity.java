package org.mdsd2016.android.dummyfragment;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, FirstFragment.ICom2Activity {

    private final static String TAG = MainActivity.class.getSimpleName();
    private FrameLayout mFragmentContainer; //reference to the container, to where fragment
    //has to be placed
    private View mMainLayout; //defines tap action
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(MainActivity.TAG, "Orientation" + getResources().getConfiguration().orientation); //this logs the orientation

        String myOrientation = getResources().getConfiguration() //give me the current orientation of the device
                .orientation == Configuration.ORIENTATION_LANDSCAPE ? // if it's equal to landsacape
                "Landscape" : // please write landscape
                "Portrait";  // if it's not landscape, write portrait

        Log.i(MainActivity.TAG, "Orientation" + myOrientation); // using variable to show what we asked above
        // *** THIS CHECKS ORIENTATION
        this.mTwoPane = getResources().getConfiguration()
                .orientation == Configuration.ORIENTATION_PORTRAIT;// <-- this is a comparison
        //if orientation of device is portrait, i have 2 panes, otherwise it's false, you are using only 1 orientation is in boolean


        if (this.mTwoPane) { //if we're in landscape mode

            this.mFragmentContainer = (FrameLayout) findViewById(R.id.frame_layout_container_activity_main);
            this.mMainLayout = findViewById(R.id.linear_layout_activity_main);
            this.mMainLayout.setOnClickListener(this);
        } else {

            final Button btnSwapFragments = (Button) this.findViewById(R.id.btn_swap_fragments);
            btnSwapFragments.setOnClickListener(this);

            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction()
                    .replace(R.id.frame_layout_container_activity_main_land,
                            new FirstFragment(),
                            "FirstFragmentLandscape")
                    .commit();
        }

    }

    @Override
    public void onClick(View whichView) {

        if (whichView.getId() == R.id.linear_layout_activity_main) {
            Log.i(MainActivity.TAG, "Clicked");
            Toast.makeText(this, "OMG THIS IS LIKE, CRAZY!", Toast.LENGTH_SHORT).show();

            //fragment manager one is support and one is non supported, the methods to call are usually different

            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction()
                    .replace(R.id.frame_layout_container_activity_main,
                            new FirstFragment(),
                            "FirstFragment")
                    .commit();
        } else if (whichView.getId() == R.id.btn_swap_fragments) {
            //if in Landscape, it's when the option happens, when this button can be clicked.IF the button clicked, swap fragments.

            FragmentManager fm = getSupportFragmentManager();
            //instantiates fragment manager

            boolean isFirstFragment = fm.findFragmentByTag("FirstFragmentLandscape") != null;

            Log.e(MainActivity.TAG, isFirstFragment == true ? "FIRST is present" : "Second is present");

            Fragment fragment;
            String fragmentTag;
            int color;

            if (isFirstFragment) {
                //if it's present replace first with second

                fragment = new SecondFragment();
                fragmentTag = "SecondFragmentLandscape";
                color = R.color.yellow;

            } else {
                fragment = new FirstFragment();
                fragmentTag = "FirstFragmentLandscape";
                color = R.color.lightGreen;
            }

            fm.beginTransaction()
                    .replace(R.id.frame_layout_container_activity_main_land,
                            fragment,
                            fragmentTag)
                    .commit();

            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_layout_activity_main_land);
            linearLayout.setBackgroundColor(ContextCompat.getColor(this, color));
        }
    }

    @Override
    public void getRandomNumberFromFragment1() {

        double randomNumber = Math.random();

        Log.i(MainActivity.TAG, "Number from Fragment 1:" + randomNumber);
        //  Fragment fragment = findViewById(R.id.);
    }

}
