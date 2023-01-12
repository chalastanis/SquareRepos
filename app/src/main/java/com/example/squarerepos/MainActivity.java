package com.example.squarerepos;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;

import com.example.squarerepos.adapter.RepoRecyclerViewAdapter;
import com.example.squarerepos.data.AsyncResponse;
import com.example.squarerepos.data.Repository;
import com.example.squarerepos.model.Repo;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RepoRecyclerViewAdapter repoRecyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.repos_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        Repository.getRepos(new AsyncResponse() {
            @Override
            public void processRepo(List<Repo> repos) {
                for (Repo repo : repos){
                        Log.d("Repos","Repo: " + repo.getName());
                        repoRecyclerViewAdapter = new RepoRecyclerViewAdapter(repos);
                        recyclerView.setAdapter(repoRecyclerViewAdapter);
                }
            }
        });
    }
}