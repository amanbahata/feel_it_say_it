package com.aman1.feelitsayit.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aman1.feelitsayit.R;
import com.aman1.feelitsayit.lab.PostLab;
import com.aman1.feelitsayit.model.Post;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostListFragment extends Fragment {
    private static final String TAG = "PostListFragment";

    private RecyclerView postRecyclerView;
    private PostListAdaptor postListAdaptor;


    public PostListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_post_list, container, false);

        updateUI();

        postRecyclerView = v.findViewById(R.id.post_list_recycler_view);
        postRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        postRecyclerView.setAdapter(postListAdaptor);

        return v;
    }

    private void updateUI(){
        PostLab postLab = PostLab.getInstance(getActivity());
        List<Post> postList = postLab.getPosts();
        postListAdaptor = new PostListAdaptor(getActivity(), postList);
    }

}
