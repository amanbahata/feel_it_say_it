package com.aman1.feelitsayit;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aman1.feelitsayit.view.PostFragment;
import com.aman1.feelitsayit.view.PostListFragment;

public class MainActivity extends SingleFragmentActivity {

    private static final String TAG = "MainActivity";


    @Override
    protected Fragment createFragment() {
        return new PostListFragment();
    }
}
