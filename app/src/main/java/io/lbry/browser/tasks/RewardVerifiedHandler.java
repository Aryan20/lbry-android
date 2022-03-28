package com.aryan.lbrybrowser.tasks;

import com.aryan.lbrybrowser.model.lbryinc.RewardVerified;

public interface RewardVerifiedHandler {
    void onSuccess(RewardVerified rewardVerified);
    void onError(Exception error);
}
