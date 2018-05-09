package com.aman1.feelitsayit.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.aman1.feelitsayit.PostActivity;
import com.aman1.feelitsayit.R;
import com.aman1.feelitsayit.lab.PostLab;
import com.aman1.feelitsayit.model.Post;

import org.w3c.dom.Text;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostListFragment extends Fragment {
    private static final String TAG = "PostListFragment";

    private RecyclerView postRecyclerView;
    private PostListAdaptor postListAdaptor;

    private TextView noPost;
    private Button addPost;


    public PostListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_post_list, container, false);


        noPost = v.findViewById(R.id.no_post_primary);
        addPost = v.findViewById(R.id.add_post);

        postRecyclerView = v.findViewById(R.id.post_list_recycler_view);
        postRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return v;
    }


    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI(){
        PostLab postLab = PostLab.getInstance(getActivity());
        List<Post> postList = postLab.getPosts();

        if (!postList.isEmpty()){
            noPost.setVisibility(View.GONE);
            addPost.setVisibility(View.GONE);
            postRecyclerView.setVisibility(View.VISIBLE);

            if (postListAdaptor == null) {
                postListAdaptor = new PostListAdaptor(getActivity(), postList);
                postRecyclerView.setAdapter(postListAdaptor);
            }
        }else {
            postRecyclerView.setVisibility(View.GONE);
            noPost.setVisibility(View.VISIBLE);
            addPost.setVisibility(View.VISIBLE);
            addPost.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Post post = new Post();
                    startAnActivity(post);
                }
            });
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_post_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_post:
                Post post = new Post();
                startAnActivity(post);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void startAnActivity(Post post){
        PostLab.getInstance(getActivity()).addPost(post);
        Intent intent = PostActivity.newIntent(getActivity(), post.getId());
        startActivity(intent);
    }
}
