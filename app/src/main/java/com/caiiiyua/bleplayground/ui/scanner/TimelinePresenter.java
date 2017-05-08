package com.caiiiyua.bleplayground.ui.scanner;


import com.caiiiyua.bleplayground.data.DataManager;
import com.caiiiyua.bleplayground.injection.ConfigPersistent;
import com.caiiiyua.bleplayground.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by CaiY on 22/12/16.
 */

@ConfigPersistent
public class TimelinePresenter extends BasePresenter<TimelineUi> {

	@Inject
	DataManager mDataManager;

	@Inject
	public TimelinePresenter() {
	}

}
