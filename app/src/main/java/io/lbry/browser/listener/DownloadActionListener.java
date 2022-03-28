package com.aryan.lbrybrowser.listener;

public interface DownloadActionListener {
    void onDownloadAction(String downloadAction, String uri, String outpoint, String fileInfoJson, double progress);
}
