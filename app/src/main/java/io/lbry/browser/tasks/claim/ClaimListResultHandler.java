package com.aryan.lbrybrowser.tasks.claim;

import java.util.List;

import com.aryan.lbrybrowser.model.Claim;

public interface ClaimListResultHandler {
    void onSuccess(List<Claim> claims);
    void onError(Exception error);
}
