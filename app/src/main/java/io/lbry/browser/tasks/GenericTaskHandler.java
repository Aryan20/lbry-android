package com.aryan.lbrybrowser.tasks;

public interface GenericTaskHandler {
    void beforeStart();
    void onSuccess();
    void onError(Exception error);
}
