package com.codepath.tonifields.instagramclone.Fragments;

import android.util.Log;

import com.codepath.tonifields.instagramclone.Post;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class ProfileFragment extends PostsFragment {
    @Override
    protected void queryPosts() {
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.include(Post.KEY_USER);
        query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());
        query.setLimit(20);
        query.addDescendingOrder(Post.KEY_CREATED_KEY);
        query.findInBackground((posts, e) -> {
            if (e != null) {
                Log.e(TAG, "Issue with getting posts", e);
                return;
            }
            for (Post post: posts) {
                Log.i(TAG, "Post: " + post.getDescription() + ", username: " + post.getUser().getUsername());
            }
            allPosts.addAll(posts);
            adapter.notifyDataSetChanged();
        });
    }
}
