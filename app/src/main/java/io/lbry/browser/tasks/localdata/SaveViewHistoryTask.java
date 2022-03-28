package com.aryan.lbrybrowser.tasks.localdata;

import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import com.aryan.lbrybrowser.data.DatabaseHelper;
import com.aryan.lbrybrowser.model.ViewHistory;

public class SaveViewHistoryTask extends AsyncTask<Void, Void, Boolean> {
    private final DatabaseHelper dbHelper;
    private final ViewHistory history;
    private final SaveViewHistoryHandler handler;
    private Exception error;

    public SaveViewHistoryTask(ViewHistory history, DatabaseHelper dbHelper, SaveViewHistoryHandler handler) {
        this.history = history;
        this.dbHelper = dbHelper;
        this.handler = handler;
    }
    protected Boolean doInBackground(Void... params) {
        try {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            DatabaseHelper.createOrUpdateViewHistoryItem(history, db);
        } catch (Exception ex) {
            error = ex;
            return false;
        }

        return true;
    }
    protected void onPostExecute(Boolean result) {
        if (handler != null) {
            if (result) {
                handler.onSuccess(history);
            } else {
                handler.onError(error);
            }
        }
    }

    public interface SaveViewHistoryHandler {
        void onSuccess(ViewHistory item);
        void onError(Exception error);
    }
}
