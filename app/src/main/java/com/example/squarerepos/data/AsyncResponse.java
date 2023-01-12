package com.example.squarerepos.data;

import com.example.squarerepos.model.Repo;

import java.util.List;

public interface AsyncResponse {
    void processRepo(List<Repo> repos);
}
