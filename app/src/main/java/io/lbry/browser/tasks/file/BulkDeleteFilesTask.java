package com.aryan.lbrybrowser.tasks.file;

import android.os.AsyncTask;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aryan.lbrybrowser.exceptions.ApiCallException;
import com.aryan.lbrybrowser.utils.Lbry;

// Just run delete on the specified claim IDs (no need for a handler)
public class BulkDeleteFilesTask extends AsyncTask<Void, Void, Boolean> {
    private final List<String> claimIds;
    public BulkDeleteFilesTask(List<String> claimIds) {
        this.claimIds = claimIds;
    }
    protected Boolean doInBackground(Void... params) {
        for (String claimId : claimIds) {
            try {
                Map<String, Object> options = new HashMap<>();
                options.put("claim_id", claimId);
                options.put("delete_from_download_dir", true);
                Lbry.genericApiCall(Lbry.METHOD_FILE_DELETE, options);
            } catch (ApiCallException ex) {
                // pass
            }
        }
        return true;
    }
}
