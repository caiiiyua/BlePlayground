package com.caiiiyua.bleplayground.ui.base;

/**
 * Created by CaiY on 7/12/16.
 */

public class BasePresenter<T extends Ui> implements Presenter<T> {

	private T mUi;
	@Override public void attachUi(T ui) {
		mUi = ui;
	}

	@Override public void detachUi() {
		mUi = null;
	}

	public boolean isUiAttached() {
		return mUi != null;
	}

	public T getUi() {
		return mUi;
	}

	public void checkUiAttached() {
		if (!isUiAttached()) throw new UiNotAttachedException();
	}

	public static class UiNotAttachedException extends RuntimeException {
		public UiNotAttachedException() {
			super("UI must not be attached to presenter");
		}
	}
}
