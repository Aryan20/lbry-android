package com.aryan.lbrybrowser.tasks.file;

import android.os.AsyncTask;

import java.util.HashMap;
import java.util.Map;

import com.aryan.lbrybrowser.exceptions.ApiCallException;
import com.aryan.lbrybrowser.tasks.GenericTaskHandler;
import com.aryan.lbrybrowser.utils.Lbry;

public class DeleteFileTask extends AsyncTask<Void, Void, Boolean> {
    private final String claimId;
    private Exception error;
    private final GenericTaskHandler handler;

    public DeleteFileTask(String claimId, GenericTaskHandler handler) {
        this.claimId = claimId;
        this.handler = handler;
    }

    protected Boolean doInBackground(Void... params) {
        try {
            Map<String, Object> options = new HashMap<>();
            options.put("claim_id", claimId);
            options.put("delete_from_download_dir", true);
            return (boolean) Lbry.genericApiCall(Lbry.METHOD_FILE_DELETE, options);
        } catch (ApiCallException ex) {
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
