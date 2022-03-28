package com.aryan.lbrybrowser.tasks;

import com.aryan.lbrybrowser.model.TwitterOauth;

public interface TwitterOauthHandler {
    void onSuccess(TwitterOauth twitterOauth);
    void onError(Exception error);
}
