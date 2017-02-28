package org.mdsd2016.android.dummyfragment;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = MainActivity.class.getSimpleName();
    private FrameLayout mFragmentContainer; //reference to the container, to where fragment
    //has to be placed
    private View mMainLayout; //defines tap action

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mFragmentContainer = (FrameLayout) findViewById(R.id.frame_layout_container_activity_main);
        this.mMainLayout = findViewById(R.id.linear_layout_activity_main);
        this.mMainLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View whichView) {

        if (whichView.getId() == R.id.linear_layout_activity_main) {
            Log.i(MainActivity.TAG, "Clicked");
            Toast.makeText(this, "OMG THIS IS LIKE, CRAZY!", Toast.LENGTH_SHORT).show();

            //fragment manager one is support and one is non supported, the methods to call are usually different

            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction()
                    .add(R.id.frame_layout_container_activity_main,
                    new BlankFragment(),
                    "FirstFragment")
                    .commit();
        }
    }
}
