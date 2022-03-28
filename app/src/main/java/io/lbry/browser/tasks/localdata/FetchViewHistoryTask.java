package com.aryan.lbrybrowser.tasks.localdata;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.aryan.lbrybrowser.data.DatabaseHelper;
import com.aryan.lbrybrowser.model.ViewHistory;
import com.aryan.lbrybrowser.utils.Helper;

public class FetchViewHistoryTask extends AsyncTask<Void, Void, List<ViewHistory>> {
    private final DatabaseHelper dbHelper;
    private final FetchViewHistoryHandler handler;
    private final int pageSize;
    private final Date lastDate;
    public FetchViewHistoryTask(Date lastDate, int pageSize, DatabaseHelper dbHelper, FetchViewHistoryHandler handler) {
        this.lastDate = lastDate;
        this.pageSize = pageSize;
        this.dbHelper = dbHelper;
        this.handler = handler;
    }
    protected List<ViewHistory> doInBackground(Void... params) {
        try {
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            return DatabaseHelper.getViewHistory(
                    lastDate == null ? null : new SimpleDateFormat(Helper.ISO_DATE_FORMAT_PATTERN).format(lastDate), pageSize, db);
        } catch (SQLiteException ex) {
            return new ArrayList<>();
        }
    }
    protected void onPostExecute(List<ViewHistory> history) {
        if (handler != null) {
            handler.onSuccess(history, history.size() < pageSize);
        }
    }

    public interface FetchViewHistoryHandler {
        void onSuccess(List<ViewHistory> history, boolean hasReachedEnd);
    }
}
