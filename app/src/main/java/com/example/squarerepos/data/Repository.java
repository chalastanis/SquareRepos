package com.example.squarerepos.data;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.squarerepos.controller.AppController;
import com.example.squarerepos.model.Repo;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    static List<Repo> reposList = new ArrayList<>();
    public static void getRepos(final AsyncResponse callback){
        JsonArrayRequest jsonArrayRequest =
                new JsonArrayRequest(Request.Method.GET, "https://api.github.com/orgs/square/repos", null, response -> {
                    for (int i = 0; i < response.length(); i++){
                        Repo repo = new Repo();
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            repo.setId(jsonObject.getString("id"));
                            repo.setName(jsonObject.getString("name"));
                            repo.setDescription(jsonObject.getString("description"));

                            reposList.add(repo);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    if (null != callback){callback.processRepo(reposList);}
                }, error -> {
                    error.printStackTrace();
                });
        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
    }
}
