package com.aryan.lbrybrowser.tasks.claim;

import android.os.AsyncTask;
import android.view.View;

import java.util.Arrays;
import java.util.List;

import com.aryan.lbrybrowser.exceptions.ApiCallException;
import com.aryan.lbrybrowser.model.Claim;
import com.aryan.lbrybrowser.tasks.claim.ClaimListResultHandler;
import com.aryan.lbrybrowser.utils.Helper;
import com.aryan.lbrybrowser.utils.Lbry;

public class ResolveTask extends AsyncTask<Void, Void, List<Claim>> {
    private final List<String> urls;
    private final String connectionString;
    private final ClaimListResultHandler handler;
    private final View progressView;
    private ApiCallException error;

    public ResolveTask(String url, String connectionString, View progressView, ClaimListResultHandler handler) {
        this(Arrays.asList(url), connectionString, progressView, handler);
    }

    public ResolveTask(List<String> urls, String connectionString, View progressView, ClaimListResultHandler handler) {
        this.urls = urls;
        this.connectionString = connectionString;
        this.progressView = progressView;
        this.handler = handler;
    }
    protected void onPreExecute() {
        Helper.setViewVisibility(progressView, View.VISIBLE);
    }
    protected List<Claim> doInBackground(Void... params) {
        try {
            return Helper.filterInvalidReposts(Lbry.resolve(urls, connectionString));
        } catch (ApiCallException ex) {
            error = ex;
            return null;
        }
    }
    protected void onPostExecute(List<Claim> claims) {
        Helper.setViewVisibility(progressView, View.GONE);
        if (handler != null) {
            if (claims != null) {
                handler.onSuccess(claims);
            } else {
                handler.onError(error);
            }
        }
    }

}
