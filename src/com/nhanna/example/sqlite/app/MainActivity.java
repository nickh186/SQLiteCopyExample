package com.nhanna.example.sqlite.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.nhanna.example.sqlite.R;
import com.nhanna.example.sqlite.frag.AboutFragment;
import com.nhanna.example.sqlite.frag.MainFragment;

public class MainActivity extends ActionBarActivity implements ActivityDecorator {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try {
			createAndAddFragment(MainFragment.TAG, MainFragment.class, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_about) {
			AboutFragment frag = new AboutFragment();
			frag.show(getSupportFragmentManager(), AboutFragment.TAG);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/* In this simple example application, the fragment functions will add the specified fragment to content frame layout.  A 
	 * container 'pattern' can be adopted to allow use in a layout where there are fixed elements that are used in each screen/fragment
	 * (status bar, time/date etc.)  */
	
	@Override
	public void createAndAddFragment(String tag, Class<? extends Fragment> cls, boolean addToBackstack) throws InstantiationException, IllegalAccessException {
		final FragmentManager man = getSupportFragmentManager();
		Fragment frag = man.findFragmentByTag(tag);
		
		if(frag == null) {
			frag = cls.newInstance();
			FragmentTransaction trans = man.beginTransaction();
			trans.add(R.id.content, frag, tag);
			if(addToBackstack) {
				trans.addToBackStack(tag);
			}
			trans.commit();
		}
		
	}
	@Override
	public void createAndAddFragment(Bundle args, String tag, Class<? extends Fragment> cls, boolean addToBackstack) throws InstantiationException, IllegalAccessException {

		final FragmentManager man = getSupportFragmentManager();
		Fragment frag = man.findFragmentByTag(tag);
		
		if(frag == null) {
			frag = cls.newInstance();
			frag.setArguments(args);
			FragmentTransaction trans = man.beginTransaction();
			trans.add(R.id.content, frag, tag);
			if(addToBackstack) {
				trans.addToBackStack(tag);
			}
			trans.commit();
		}
	}
}
