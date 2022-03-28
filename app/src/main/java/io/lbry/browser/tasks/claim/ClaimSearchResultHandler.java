package com.aryan.lbrybrowser.tasks.claim;

import java.util.List;

import com.aryan.lbrybrowser.model.Claim;

public interface ClaimSearchResultHandler {
    void onSuccess(List<Claim> claims, boolean hasReachedEnd);
    void onError(Exception error);
}
