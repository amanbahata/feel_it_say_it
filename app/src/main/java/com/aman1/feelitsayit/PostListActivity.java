package com.aman1.feelitsayit;


import android.support.v4.app.Fragment;

import com.aman1.feelitsayit.view.PostListFragment;

public class PostListActivity extends SingleFragmentActivity{

    private static final String TAG = "PostListActivity";

    @Override
    protected Fragment createFragment() {
        return new PostListFragment();
    }
}
