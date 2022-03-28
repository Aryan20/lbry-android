package com.aryan.lbrybrowser.listener;

import com.aryan.lbrybrowser.model.Claim;

public interface ChannelItemSelectionListener {
    void onChannelItemSelected(Claim claim);
    void onChannelItemDeselected(Claim claim);
    void onChannelSelectionCleared();
}
