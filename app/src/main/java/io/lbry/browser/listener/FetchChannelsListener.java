package com.aryan.lbrybrowser.listener;

import java.util.List;

import com.aryan.lbrybrowser.model.Claim;

public interface FetchChannelsListener {
    void onChannelsFetched(List<Claim> channels);
}
