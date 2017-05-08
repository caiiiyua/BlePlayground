package com.caiiiyua.bleplayground.injection.component;


import com.caiiiyua.bleplayground.injection.ConfigPersistent;
import com.caiiiyua.bleplayground.injection.module.ActivityModule;
import com.caiiiyua.bleplayground.injection.module.FragmentModule;

import dagger.Component;

@ConfigPersistent
@Component(dependencies = ApplicationComponent.class)
public interface ConfigPersistentComponent {
    ActivityComponent activityComponent(ActivityModule activityModule);
    FragmentComponent fragmentComponent(FragmentModule fragmentModule);
}