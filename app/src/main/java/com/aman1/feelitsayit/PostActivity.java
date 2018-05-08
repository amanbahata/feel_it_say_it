package com.aman1.feelitsayit;

import android.support.v4.app.Fragment;

import com.aman1.feelitsayit.view.PostFragment;

public class PostActivity extends SingleFragmentActivity {

    private static final String TAG = "PostActivity";


    @Override
    protected Fragment createFragment() {
        return PostFragment.getInstance();
    }
}
