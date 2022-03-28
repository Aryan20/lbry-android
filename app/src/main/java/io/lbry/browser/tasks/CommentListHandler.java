package com.aryan.lbrybrowser.tasks;

import java.util.List;

import com.aryan.lbrybrowser.model.Comment;

public interface CommentListHandler {
    void onSuccess(List<Comment> comments, boolean hasReachedEnd);
    void onError(Exception error);
}
