package com.nhanna.example.sqlite.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public interface ActivityDecorator {

	/**
	 * Creates and adds a fragment to the {@link Activity}'s layout
	 * @param tag - {@link Fragment} tag
	 * @param cls - {@link Class} of the {@link Fragment} to instantiate
	 * @param addToBackstack - true to add to backstack
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void createAndAddFragment(String tag, Class<? extends Fragment> cls, boolean addToBackstack) throws InstantiationException, IllegalAccessException;

	/**
	 * Creates and adds a fragment to the {@link Activity}'s layout
	 * @param args - optional {@link Bundle} to set as args
	 * @param tag - {@link Fragment} tag
	 * @param cls - {@link Class} of the {@link Fragment} to instantiate
	 * @param addToBackstack - true to add to backstack
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void createAndAddFragment(Bundle args, String tag, Class<? extends Fragment> cls, boolean addToBackstack) throws InstantiationException, IllegalAccessException;
}
