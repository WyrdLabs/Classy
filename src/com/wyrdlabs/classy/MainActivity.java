package com.wyrdlabs.classy;

import com.theapakgroup.android.DocumentListFragment;
import com.theapakgroup.android.R;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		FragmentManager fm = getFragmentManager();
		Fragment timelineFragment = fm.findFragmentByTag("timeline");
		if (timelineFragment == null) {
			Fragment fragment = new TimelineFragment();
			
			fragment.setRetainInstance(true);
			
			fm.beginTransaction()
			  .replace(R.id.main_content_frame, fragment, "timeline")
			  .commit();
			
			getActionBar().setTitle("Timeline");
		}
		
		FragmentManager fm = getFragmentManager();
		Fragment docFragment = fm.findFragmentByTag("documents");
		if (docFragment == null) {
			DocumentListFragment fragment = new DocumentListFragment();
			
			fragment.setRetainInstance(true);
			
			fm.beginTransaction()
			  .replace(R.id.main_content_frame, fragment, "documents")
			  .commit();
			
			mCurrentFragment = fragment;
			getActionBar().setTitle(title);

		
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

	}

}
