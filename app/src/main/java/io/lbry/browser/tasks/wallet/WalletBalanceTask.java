package com.aryan.lbrybrowser.tasks.wallet;

import android.os.AsyncTask;

import org.json.JSONObject;

import com.aryan.lbrybrowser.exceptions.ApiCallException;
import com.aryan.lbrybrowser.model.WalletBalance;
import com.aryan.lbrybrowser.utils.Lbry;

public class WalletBalanceTask extends AsyncTask<Void, Void, WalletBalance> {
    private final WalletBalanceHandler handler;
    private Exception error;

    public WalletBalanceTask(WalletBalanceHandler handler) {
        this.handler = handler;
    }

    protected WalletBalance doInBackground(Void... params) {
       WalletBalance balance;
        try {
            JSONObject json = (JSONObject) Lbry.genericApiCall(Lbry.METHOD_WALLET_BALANCE);
            balance = WalletBalance.fromJSONObject(json);
        } catch (ApiCallException | ClassCastException ex) {
            error = ex;
            return null;
        }

        return balance;
    }

    protected void onPostExecute(WalletBalance walletBalance) {
        if (handler != null) {
            if (walletBalance != null) {
                handler.onSuccess(walletBalance);
            } else {
                handler.onError(error);
            }
        }
    }

    public interface WalletBalanceHandler {
        void onSuccess(WalletBalance walletBalance);
        void onError(Exception error);
    }
}
