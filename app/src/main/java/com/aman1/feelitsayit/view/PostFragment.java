package com.aman1.feelitsayit.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.aman1.feelitsayit.R;
import com.aman1.feelitsayit.lab.PostLab;
import com.aman1.feelitsayit.model.Post;

import java.text.DateFormat;
import java.util.UUID;


/**
 * A simple {@link Fragment} subclass.
 */
public class PostFragment extends Fragment {

    private static final String TAG = "PostFragment";
    private static final String ARG_POST_ID = "post_id";

    private Post post;

    private EditText postTitle;
    private EditText postDetails;
    private Button postDate;


    public PostFragment() {
        // Required empty public constructor
    }

    public static PostFragment newInstance(UUID postId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_POST_ID, postId);
        PostFragment fragment = new PostFragment();
        fragment.setArguments(args);

        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID postId = (UUID) getArguments().getSerializable(ARG_POST_ID);
        this.post = PostLab.getInstance(getActivity()).getPost(postId);

        Log.i(TAG, "onCreate: " + this.post);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_post, container, false);

        postTitle = v.findViewById(R.id.post_title);
        postTitle.setText(post.getTitle());
        postTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                post.setTitle(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        postDetails = v.findViewById(R.id.post_details);
        postDetails.setText(post.getDetails());
        postDetails.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                post.setDetails(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        postDate = v.findViewById(R.id.post_date);
        postDate.setText(DateFormat.getDateInstance(DateFormat.FULL).format(post.getDate()));
        postDate.setEnabled(false);


        return v;
    }

}
