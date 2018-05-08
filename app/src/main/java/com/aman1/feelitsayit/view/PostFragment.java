package com.aman1.feelitsayit.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.aman1.feelitsayit.R;
import com.aman1.feelitsayit.model.Post;
import com.aman1.feelitsayit.utilities.DateFormatter;


/**
 * A simple {@link Fragment} subclass.
 */
public class PostFragment extends Fragment {

    private static final String TAG = "PostFragment";
    private PostFragment postFragment;

    private Post post;

    private EditText postTitle;
    private EditText postDetails;
    private Button postDate;




    public PostFragment() {
        // Required empty public constructor
    }

    public PostFragment getInstance(){
        if (postFragment == null){
            postFragment = new PostFragment();
        }
        return postFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        post = new Post();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_post, container, false);

        postTitle = v.findViewById(R.id.post_title);
        postDetails = v.findViewById(R.id.post_details);
        postDate = v.findViewById(R.id.post_date);
        postDate.setText(DateFormatter.formateDate(post.getDate()));
        postDate.setEnabled(false);

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

        return v;
    }

}
