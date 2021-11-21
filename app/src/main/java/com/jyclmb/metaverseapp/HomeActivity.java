package com.jyclmb.metaverseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.jyclmb.metaverseapp.adapters.PostsAdapter;
import com.jyclmb.metaverseapp.pojos.Posts;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    public RecyclerView postsRecyclerView;
    public List<Posts> postsList;
    public PostsAdapter postsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        postsRecyclerView = findViewById(R.id.postsRecyclerView);
        postsList = new ArrayList<>();
        postsAdapter = new PostsAdapter(postsList, this);
        postsRecyclerView.setAdapter(postsAdapter);
        postsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void populatePosts(){
        postsList.add(new Posts("1", "Test", "Test category", "Test Description", null, null, null, "jay handsome"));
        postsAdapter.notifyDataSetChanged();
    }
}