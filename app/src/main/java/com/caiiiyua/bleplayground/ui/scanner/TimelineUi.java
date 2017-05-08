package com.caiiiyua.bleplayground.ui.scanner;

import com.caiiiyua.bleplayground.data.local.Timeline;
import com.caiiiyua.bleplayground.ui.base.Ui;

import java.util.List;

/**
 * Created by CaiY on 22/12/16.
 */
public interface TimelineUi extends Ui {
    void showTimeline(List<Timeline> timelines);
    void showEmptyTimeline();

    void showInvalidUpdate(String title);
}
