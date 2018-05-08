package com.aman1.feelitsayit;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.aman1.feelitsayit.view.PostFragment;

import java.util.UUID;

public class PostActivity extends SingleFragmentActivity {

    private static final String TAG = "PostActivity";
    public static String EXTRA_POST_ID = "com.aman1.feelitsayit.post_id";

    @Override
    protected Fragment createFragment() {
        UUID postId = (UUID) getIntent().getSerializableExtra(EXTRA_POST_ID);
        return PostFragment.newInstance(postId);
    }

    public static Intent newIntent(Context packageContext, UUID id){
        Intent intent = new Intent(packageContext, PostActivity.class);
        intent.putExtra(EXTRA_POST_ID, id);
        return intent;
    }
}

