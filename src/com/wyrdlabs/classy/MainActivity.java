package com.wyrdlabs.classy;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends Activity implements DoubleDrawered {

	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	private View mNavDrawer;
	private View mActionDrawer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.i("MainActivity", "in onCreate()");

		setContentView(R.layout.activity_main);

		// Find and save UI components
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mNavDrawer = (View) findViewById(R.id.nav_drawer);
		mActionDrawer = (View) findViewById(R.id.action_drawer);

		// Setup drawer

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {

			public void onDrawerOpened(View drawerView) {

				invalidateOptionsMenu();

			}

			public void onDrawerClosed(View drawerView) {

				invalidateOptionsMenu();

			}

		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);

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

	/* Used by drawer toggle */
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

		// Sync the toggle state after onRestoreInstanceState has occurred
		mDrawerToggle.syncState();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item))
			return true;

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
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

	@Override
	public boolean isDrawerOpen() {
		return isNavDrawerOpen() || isActionDrawerOpen();
	}

	@Override
	public boolean isNavDrawerOpen() {
		return mDrawerLayout.isDrawerOpen(mNavDrawer);
	}

	@Override
	public boolean isActionDrawerOpen() {
		return mDrawerLayout.isDrawerOpen(mActionDrawer);
	}
	


}
