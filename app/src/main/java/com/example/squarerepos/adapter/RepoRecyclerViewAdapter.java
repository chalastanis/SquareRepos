package com.example.squarerepos.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.squarerepos.R;
import com.example.squarerepos.model.Owner;
import com.example.squarerepos.model.Repo;

import java.util.List;

public class RepoRecyclerViewAdapter extends RecyclerView.Adapter<RepoRecyclerViewAdapter.ViewHolder>  {
    private final List<Repo> repoList;

    public RepoRecyclerViewAdapter(List<Repo> repoList) {
        this.repoList = repoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.repos_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Repo repo = repoList.get(position);
        holder.repoName.setText(repo.getName());
        holder.repoDescription.setText(repo.getDescription());
        holder.repoIcon.setImageResource(R.drawable.foldergreen);

    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView repoIcon;
        public TextView repoName;
        public TextView repoDescription;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            repoIcon = itemView.findViewById(R.id.row_repo_icon);
            repoName = itemView.findViewById(R.id.row_name_textview);
            repoDescription = itemView.findViewById(R.id.row_description_textview);
        }
    }
}
