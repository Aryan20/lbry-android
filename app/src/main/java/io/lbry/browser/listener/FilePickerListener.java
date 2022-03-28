package com.aryan.lbrybrowser.listener;

public interface FilePickerListener {
    void onFilePicked(String filePath);
    void onFilePickerCancelled();
}
