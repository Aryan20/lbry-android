package com.aryan.lbrybrowser.tasks.lbryinc;

import android.os.AsyncTask;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;

import com.aryan.lbrybrowser.exceptions.LbryioRequestException;
import com.aryan.lbrybrowser.exceptions.LbryioResponseException;
import com.aryan.lbrybrowser.utils.Helper;
import com.aryan.lbrybrowser.utils.Lbryio;

public class FetchReferralCodeTask extends AsyncTask<Void, Void, String> {
    private final FetchReferralCodeHandler handler;
    private final View progressView;
    private Exception error;

    public FetchReferralCodeTask(View progressView, FetchReferralCodeHandler handler) {
        this.progressView = progressView;
        this.handler = handler;
    }

    protected void onPreExecute() {
        Helper.setViewVisibility(progressView, View.VISIBLE);
    }

    protected String doInBackground(Void... params) {
        String referralCode = null;
        try {
            JSONArray results = (JSONArray) Lbryio.parseResponse(Lbryio.call("user_referral_code", "list", null, null));
            if (results.length() > 0) {
                referralCode = results.getString(0);
            }
        } catch (ClassCastException | LbryioRequestException | LbryioResponseException | JSONException ex) {
            error = ex;
        }

        return referralCode;
    }

    protected void onPostExecute(String referralCode) {
        Helper.setViewVisibility(progressView, View.GONE);
        if (handler != null) {
            if (!Helper.isNullOrEmpty(referralCode)) {
                handler.onSuccess(referralCode);
            } else {
                handler.onError(error);
            }
        }
    }

    public interface FetchReferralCodeHandler {
        void onSuccess(String referralCode);
        void onError(Exception error);
    }
}
