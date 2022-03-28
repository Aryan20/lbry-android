package com.aryan.lbrybrowser.listener;

import com.aryan.lbrybrowser.model.Tag;

public interface TagListener {
    void onTagAdded(Tag tag);
    void onTagRemoved(Tag tag);
}
