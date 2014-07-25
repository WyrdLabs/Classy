package com.wyrdlabs.classy;

import com.wyrdlabs.classy.R;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class MainActivity extends Activity implements DoubleDrawered {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Log.i("MainActivity", "in onCreate()");

		setContentView(R.layout.activity_main);

		FragmentManager fm = getFragmentManager();
		Fragment timelineFragment = fm.findFragmentByTag("timeline");
		if (timelineFragment == null) {
			Fragment fragment = new TimelineFragment();
			
			fragment.setRetainInstance(true);
			
			fm.beginTransaction()
			  .replace(R.id.main_content_frame, fragment, "timeline")
			  .commit();
			
			getActionBar().setTitle(TimelineFragment.TITLE);
		}
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

	}
	
	public ViewGroup getActionDrawer() {
		return (ViewGroup) findViewById(R.id.action_drawer);
	}	

	@Override
	public ViewGroup getNavDrawer() {
		return (ViewGroup) findViewById(R.id.nav_drawer);
	}

	@Override
	public DrawerLayout getDrawerLayout() {
		return (DrawerLayout) findViewById(R.id.drawer_layout);
	}

}
