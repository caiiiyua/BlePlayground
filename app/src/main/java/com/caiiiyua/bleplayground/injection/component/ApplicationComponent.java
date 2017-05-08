package com.caiiiyua.bleplayground.injection.component;

import android.content.Context;

import com.caiiiyua.bleplayground.data.DataManager;
import com.caiiiyua.bleplayground.injection.ApplicationContext;
import com.caiiiyua.bleplayground.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by pp on 25/01/17.
 */
@Singleton
@Component (modules = ApplicationModule.class)
public interface ApplicationComponent {
    @ApplicationContext
    Context context();
    DataManager getDataManager();
}
