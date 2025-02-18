package com.aryan.lbrybrowser.tasks.lbryinc;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.aryan.lbrybrowser.model.lbryinc.RewardVerified;
import com.aryan.lbrybrowser.tasks.RewardVerifiedHandler;
import com.aryan.lbrybrowser.utils.Helper;
import com.aryan.lbrybrowser.utils.Lbryio;

public class AndroidPurchaseTask extends AsyncTask<Void, Void, RewardVerified> {
    private final Context context;
    private final View progressView;
    private final String purchaseToken;
    private final RewardVerifiedHandler handler;
    private Exception error;

    public AndroidPurchaseTask(String purchaseToken, View progressView, Context context, RewardVerifiedHandler handler) {
        this.purchaseToken = purchaseToken;
        this.progressView = progressView;
        this.context = context;
        this.handler = handler;
    }

    protected void onPreExecute() {
        Helper.setViewVisibility(progressView, View.VISIBLE);
    }

    protected RewardVerified doInBackground(Void... params) {
        try {
            Map<String, String> options = new HashMap<>();
            options.put("purchase_token", purchaseToken);

            JSONObject object = (JSONObject) Lbryio.parseResponse(Lbryio.call("verification", "android_purchase", options, context));
            Type type = new TypeToken<RewardVerified>(){}.getType();
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            return gson.fromJson(object.toString(), type);
        } catch (Exception ex) {
            error = ex;
            return null;
        }
    }

    protected void onPostExecute(RewardVerified result) {
        Helper.setViewVisibility(progressView, View.GONE);
        if (handler != null) {
            if (result != null) {
                handler.onSuccess(result);
            } else {
                handler.onError(error);
            }
        }
    }
}
