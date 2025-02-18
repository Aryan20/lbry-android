package com.aryan.lbrybrowser.tasks.lbryinc;

import android.os.AsyncTask;

import java.util.HashMap;
import java.util.Map;

import com.aryan.lbrybrowser.exceptions.LbryioRequestException;
import com.aryan.lbrybrowser.exceptions.LbryioResponseException;
import com.aryan.lbrybrowser.model.Claim;
import com.aryan.lbrybrowser.utils.Lbryio;

public class LogPublishTask extends AsyncTask<Void, Void, Void> {
    private final Claim claimResult;
    public LogPublishTask(Claim claimResult) {
        this.claimResult = claimResult;
    }
    protected Void doInBackground(Void... params) {
        try {
            Map<String, String> options = new HashMap<>();
            options.put("uri", claimResult.getPermanentUrl());
            options.put("claim_id", claimResult.getClaimId());
            options.put("outpoint", String.format("%s:%d", claimResult.getTxid(), claimResult.getNout()));
            if (claimResult.getSigningChannel() != null) {
                options.put("channel_claim_id", claimResult.getSigningChannel().getClaimId());
            }
            Lbryio.call("event", "publish", options,  null).close();
        } catch (LbryioRequestException | LbryioResponseException ex) {
            // pass
        }
        return null;
    }
}
