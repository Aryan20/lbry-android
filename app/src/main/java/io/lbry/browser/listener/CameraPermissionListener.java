package com.aryan.lbrybrowser.listener;

public interface CameraPermissionListener {
    void onCameraPermissionGranted();
    void onCameraPermissionRefused();
    void onRecordAudioPermissionGranted();
    void onRecordAudioPermissionRefused();
}
