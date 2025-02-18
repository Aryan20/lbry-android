package com.aryan.lbrybrowser.tasks;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import com.aryan.lbrybrowser.exceptions.LbryRequestException;
import com.aryan.lbrybrowser.exceptions.LbryResponseException;
import com.aryan.lbrybrowser.model.Claim;
import com.aryan.lbrybrowser.tasks.claim.ClaimSearchResultHandler;
import com.aryan.lbrybrowser.utils.Helper;
import com.aryan.lbrybrowser.utils.Lighthouse;

public class LighthouseSearchTask extends AsyncTask<Void, Void, List<Claim>> {
    private final String rawQuery;
    private final int size;
    private final int from;
    private final boolean nsfw;
    private final String relatedTo;
    private final ClaimSearchResultHandler handler;
    private final ProgressBar progressBar;
    private Exception error;

    public LighthouseSearchTask(String rawQuery, int size, int from, boolean nsfw, String relatedTo, ProgressBar progressBar, ClaimSearchResultHandler handler) {
        this.rawQuery = rawQuery;
        this.size = size;
        this.from = from;
        this.nsfw = nsfw;
        this.relatedTo = relatedTo;
        this.progressBar = progressBar;
        this.handler = handler;
    }
    protected void onPreExecute() {
        Helper.setViewVisibility(progressBar, View.VISIBLE);
    }
    protected List<Claim> doInBackground(Void... params) {
        try {
            return Lighthouse.search(rawQuery, size, from, nsfw, relatedTo);
        } catch (LbryRequestException | LbryResponseException ex) {
            error = ex;
            return null;
        }
    }
    protected void onPostExecute(List<Claim> claims) {
        Helper.setViewVisibility(progressBar, View.GONE);
        if (handler != null) {
            if (claims != null) {
                handler.onSuccess(claims, claims.size() < size);
            } else {
                handler.onError(error);
            }
        }
    }
}
