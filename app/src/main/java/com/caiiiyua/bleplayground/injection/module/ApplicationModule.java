package com.caiiiyua.bleplayground.injection.module;

import android.app.Application;
import android.content.Context;

import com.caiiiyua.bleplayground.injection.ApplicationContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pp on 25/01/17.
 */

@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

}
