package com.caiiiyua.bleplayground.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.caiiiyua.bleplayground.BlePlaygroundApplication;
import com.caiiiyua.bleplayground.injection.component.ConfigPersistentComponent;
import com.caiiiyua.bleplayground.injection.component.DaggerConfigPersistentComponent;
import com.caiiiyua.bleplayground.injection.component.FragmentComponent;
import com.caiiiyua.bleplayground.injection.module.FragmentModule;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by stuarts on 4/01/17.
 */

public class BaseFragment extends Fragment {

	private static final String KEY_FRAGMENT_ID = "KEY_FRAGMENT_ID";
	private static final Map<Long, ConfigPersistentComponent> sComponentsMap = new HashMap<>();
	private static final AtomicLong NEXT_ID = new AtomicLong(0);

	private FragmentComponent mFragmentComponent;
	private long mFragmentId;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Create the FragmentComponent and reuses cached ConfigPersistentComponent if this is
		// being called after a configuration change.
		mFragmentId = savedInstanceState != null ?
			savedInstanceState.getLong(KEY_FRAGMENT_ID) : NEXT_ID.getAndIncrement();
		ConfigPersistentComponent configPersistentComponent;
		if (!sComponentsMap.containsKey(mFragmentId)) {
			configPersistentComponent = DaggerConfigPersistentComponent.builder()
				.applicationComponent(BlePlaygroundApplication.get(
					getActivity()).getComponent())
				.build();
			sComponentsMap.put(mFragmentId, configPersistentComponent);
		} else {
			configPersistentComponent = sComponentsMap.get(mFragmentId);
		}
		mFragmentComponent = configPersistentComponent.fragmentComponent(new FragmentModule(this));
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putLong(KEY_FRAGMENT_ID, mFragmentId);
	}

	@Override
	public void onDestroy() {
		if (!getActivity().isChangingConfigurations()) {
			sComponentsMap.remove(mFragmentId);
		}
		super.onDestroy();
	}

	public FragmentComponent fragmentComponent() {
		return mFragmentComponent;
	}
}
