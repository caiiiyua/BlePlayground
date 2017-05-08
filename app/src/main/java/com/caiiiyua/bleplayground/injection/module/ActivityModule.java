package com.caiiiyua.bleplayground.injection.module;

import android.app.Activity;
import android.content.Context;

import com.caiiiyua.bleplayground.injection.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pp on 25/01/17.
 */
@Module
public final class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityContext
    Context providesContext() {
        return mActivity;
    }
}
