package com.caiiiyua.bleplayground.injection.component;


import com.caiiiyua.bleplayground.injection.PerActivity;
import com.caiiiyua.bleplayground.injection.module.ActivityModule;
import com.caiiiyua.bleplayground.ui.main.MainActivity;
import com.caiiiyua.bleplayground.ui.scanner.TimelineActivity;

import dagger.Subcomponent;

/**
 * Created by CaiY on 22/12/16.
 */

@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
	void inject(MainActivity activity);

	void inject(TimelineActivity timelineActivity);
}
