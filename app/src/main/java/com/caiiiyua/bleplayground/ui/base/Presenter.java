package com.caiiiyua.bleplayground.ui.base;


/**
 * Created by CaiY on 7/12/16.
 */

public interface Presenter<V extends Ui> {
	void attachUi(V ui);
	void detachUi();
}
