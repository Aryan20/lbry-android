package com.aryan.lbrybrowser.tasks.claim;

import android.os.AsyncTask;
import android.view.View;

import java.util.List;
import java.util.Map;

import com.aryan.lbrybrowser.exceptions.ApiCallException;
import com.aryan.lbrybrowser.model.Claim;
import com.aryan.lbrybrowser.utils.Helper;
import com.aryan.lbrybrowser.utils.Lbry;

public class ClaimSearchTask extends AsyncTask<Void, Void, List<Claim>> {
    private final Map<String, Object> options;
    private final String connectionString;
    private final ClaimSearchResultHandler handler;
    private final View progressView;
    private ApiCallException error;

    public ClaimSearchTask(Map<String, Object> options, String connectionString, View progressView, ClaimSearchResultHandler handler) {
        this.options = options;
        this.connectionString = connectionString;
        this.progressView = progressView;
        this.handler = handler;
    }
    protected void onPreExecute() {
        Helper.setViewVisibility(progressView, View.VISIBLE);
    }
    protected List<Claim> doInBackground(Void... params) {
        try {
            return Lbry.claimSearch(options, connectionString);
        } catch (ApiCallException ex) {
            error = ex;
            return null;
        }
    }
    protected void onPostExecute(List<Claim> claims) {
        Helper.setViewVisibility(progressView, View.GONE);
        if (handler != null) {
            if (claims != null) {
                handler.onSuccess(Helper.filterInvalidReposts(claims), claims.size() < Helper.parseInt(options.get("page_size"), 0));
            } else {
                handler.onError(error);
            }
        }
    }

}
