package com.example.squarerepos.model;

import android.net.Uri;

public class Owner{
    public String login;
    public int id;
    public String node_id;

    public Uri getAvatar_url() {
        return Uri.parse(avatar_url);
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String avatar_url;
    public String gravatar_id;
    public String url;
    public String html_url;
    public String followers_url;
    public String following_url;
    public String gists_url;
    public String starred_url;
    public String subscriptions_url;
    public String organizations_url;
    public String repos_url;
    public String events_url;
    public String received_events_url;
    public String type;
    public boolean site_admin;
}
