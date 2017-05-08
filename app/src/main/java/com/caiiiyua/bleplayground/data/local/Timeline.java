package com.caiiiyua.bleplayground.data.local;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by pp on 29/01/17.
 */

public class Timeline implements Parcelable {
    public static final int EVENT_EOI = 0;
    public static final int EVENT_ITA = 1;
    public static final int EVENT_AR = 2;
    public static final int EVENT_SC = 3;
    public static final int EVENT_AIP = 4;
    public static final int EVENT_RRV = 5;
    public static final int EVENT_MAX = 6;

    private int id;
    private long date;
    private String title;
    private String summary;
    private int type;

    public Timeline(Parcel in) {
    }

    public static final Creator<Timeline> CREATOR = new Creator<Timeline>() {
        @Override
        public Timeline createFromParcel(Parcel in) {
            return new Timeline(in);
        }

        @Override
        public Timeline[] newArray(int size) {
            return new Timeline[size];
        }
    };

    public Timeline() {

    }

    public Timeline(long date, String title, String summary, int type) {
        this.date = date;
        this.title = title;
        this.summary = summary;
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
