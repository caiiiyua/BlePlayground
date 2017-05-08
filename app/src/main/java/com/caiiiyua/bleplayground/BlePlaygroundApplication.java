package com.caiiiyua.bleplayground;

import android.app.Application;
import android.content.Context;

import com.caiiiyua.bleplayground.injection.component.ApplicationComponent;
import com.caiiiyua.bleplayground.injection.component.DaggerApplicationComponent;
import com.caiiiyua.bleplayground.injection.module.ApplicationModule;
import com.facebook.stetho.Stetho;

/**
 * Created by pp on 25/01/17.
 */

public class BlePlaygroundApplication extends Application {

    private static final String TAG = BlePlaygroundApplication.class.getSimpleName();
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }
    }

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }

    public static BlePlaygroundApplication get(Context context) {
        return (BlePlaygroundApplication) context.getApplicationContext();
    }
}
