package com.aryan.lbrybrowser.tasks.wallet;

import android.os.AsyncTask;

import java.util.HashMap;
import java.util.Map;

import com.aryan.lbrybrowser.exceptions.ApiCallException;
import com.aryan.lbrybrowser.tasks.GenericTaskHandler;
import com.aryan.lbrybrowser.utils.Lbry;

public class UnlockTipsTask extends AsyncTask<Void, Void, Boolean> {

    private final GenericTaskHandler handler;
    private Exception error;

    public UnlockTipsTask(GenericTaskHandler handler) {
        this.handler = handler;
    }

    public Boolean doInBackground(Void... params) {
        try {
            Map<String, Object> options = new HashMap<>();
            options.put("type", "support");
            options.put("is_not_my_input", true);
            options.put("blocking", true);

            Lbry.genericApiCall(Lbry.METHOD_TXO_SPEND, options);

            return true;
        } catch (ApiCallException | ClassCastException ex) {
            error = ex;
            return false;
        }
    }

    protected void onPostExecute(Boolean result) {
        if (handler != null) {
            if (result) {
                handler.onSuccess();
            } else {
                handler.onError(error);
            }
        }
    }
}
