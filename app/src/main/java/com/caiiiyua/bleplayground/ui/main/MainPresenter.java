package com.caiiiyua.bleplayground.ui.main;


import com.caiiiyua.bleplayground.injection.ConfigPersistent;
import com.caiiiyua.bleplayground.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by CaiY on 22/12/16.
 */

@ConfigPersistent
public class MainPresenter extends BasePresenter<MainUi> {

	@Inject
	public MainPresenter() {

	}
}
