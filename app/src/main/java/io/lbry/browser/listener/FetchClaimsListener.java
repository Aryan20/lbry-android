package com.aryan.lbrybrowser.listener;

import java.util.List;

import com.aryan.lbrybrowser.model.Claim;

public interface FetchClaimsListener {
    void onClaimsFetched(List<Claim> claims);
}
