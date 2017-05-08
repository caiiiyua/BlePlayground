package com.caiiiyua.bleplayground.data.local;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by pp on 5/02/17.
 */

public class User implements Parcelable {

    private String id;
    private String name;
    private String email;
    private long joinAt;
    private List<Timeline> timelines;

    public User() {
    }

    public User(String id, String name, String email, long joinAt, List<Timeline> timelines) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.joinAt = joinAt;
        this.timelines = timelines;
    }

    protected User(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getJoinAt() {
        return joinAt;
    }

    public void setJoinAt(long joinAt) {
        this.joinAt = joinAt;
    }

    public List<Timeline> getTimelines() {
        return timelines;
    }

    public void setTimelines(List<Timeline> timelines) {
        this.timelines = timelines;
    }
}
