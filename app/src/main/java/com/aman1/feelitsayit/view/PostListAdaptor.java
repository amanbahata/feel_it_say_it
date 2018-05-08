package com.aman1.feelitsayit.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aman1.feelitsayit.R;
import com.aman1.feelitsayit.model.Post;
import com.aman1.feelitsayit.utilities.DateFormatter;

import java.util.List;

public class PostListAdaptor extends RecyclerView.Adapter<PostListAdaptor.ViewHolder> {

    private final Context context;
    private List<Post> postList;

    public PostListAdaptor(Context context, List<Post> postList){
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_post, parent, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(postList.get(position));
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private Post post;

        private TextView postTitle;
        private TextView postDate;

        ViewHolder(View view) {
            super(view);
            postTitle = view.findViewById(R.id.post_title);
            postDate = view.findViewById(R.id.post_date);
        }

        public void bind(Post post){
            this.post = post;
            postTitle.setText(this.post.getTitle());
            postDate.setText(DateFormatter.formateDate(this.post.getDate()));
        }
    }
}
