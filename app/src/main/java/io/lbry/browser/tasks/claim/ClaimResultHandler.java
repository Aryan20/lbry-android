package com.aryan.lbrybrowser.tasks.claim;

import com.aryan.lbrybrowser.model.Claim;

public interface ClaimResultHandler {
    void beforeStart();
    void onSuccess(Claim claimResult);
    void onError(Exception error);
}
