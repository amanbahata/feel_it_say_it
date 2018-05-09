package com.aman1.feelitsayit.lab;

import android.content.Context;

import com.aman1.feelitsayit.model.Post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PostLab {

    private static PostLab postLab;
    private Context context;
    private ArrayList<Post> postsList;

    private PostLab(Context context) {
        this.context = context;
        postsList = new ArrayList<>();

        // Generate 100 Random posts
//        for (int i = 0; i < 100; i ++){
//            Post post = new Post();
//            post.setTitle("Post #" + i);
//            post.setDetails("These are the details of post #" + i);
//
//            postsList.add(post);
        }


    public static PostLab getInstance(Context context){
        if (postLab == null){
            postLab = new PostLab(context);
        }
        return postLab;
    }

    public void addPost(Post post){
        postsList.add(post);
    }

    public List<Post>  getPosts(){
        return postsList;
    }

    public Post getPost(UUID id){
        for (Post post : postsList){
            if (post.getId().equals(id)){
                return post;
            }
        }
        return null;
    }
}
