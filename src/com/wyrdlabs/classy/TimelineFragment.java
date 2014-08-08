package com.wyrdlabs.classy;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TimelineFragment extends ListFragment {

	public static String TITLE = "Timeline";

	private Activity mActivity;
	private View mActionDrawer;
	private DoubleDrawered mDoubleDrawer;

	public TimelineFragment() {
		setRetainInstance(true);
		setHasOptionsMenu(true);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.i("TimelineFragment", "in onCreate()");
	}

	@Override
	public void onPause() {
		super.onPause();

		Log.i("TimelineFragment", "in onPause()");
	}

	@Override
	public void onStart() {
		super.onStart();

		Log.i("TimelineFragment", "in onStart()");
	}

	@Override
	public void onStop() {
		super.onStop();

		Log.i("TimelineFragment", "in onStop()");
	}

	@Override
	public void onResume() {
		super.onResume();

		Log.i("TimelineFragment", "in onResume()");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		Log.i("TimelineFragment", "in onDestroy()");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i("TimelineFragment", "in onCreateView()");

		View view = inflater.inflate(R.layout.timeline, container, false);

		return view;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		Log.i("TimelineFragment", "in onAttach()");

		// Save activity
		mActivity = activity;
		mDoubleDrawer = (DoubleDrawered) activity;

		// Attach data
		ListAdapter adapter = new ArrayAdapter<String>(activity,
				R.layout.timeline_item, R.id.event_title,
				new ArrayList<String>() {
					{
						add("e1");
						add("e2");
						add("e3");
						add("e4");
					}
				});

		setListAdapter(adapter);

		// Change activity UI

		// Setup action drawer
		LayoutInflater inflater = activity.getLayoutInflater();
		ViewGroup actionDrawerViewGroup = ((DoubleDrawered) activity)
				.getActionDrawer();
		actionDrawerViewGroup.removeAllViews();

		mActionDrawer = inflater.inflate(R.layout.timeline_action_drawer_uneditable,
				actionDrawerViewGroup);

	}

	@Override
	public void onDetach() {
		super.onDetach();
	}

	// Add this fragment's menu items
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		Log.i("TimelineFragment", "in onCreateOptionsMenu()");
		inflater.inflate(R.menu.timeline, menu);
	}

	// Called right before the menu is shown, every time it is shown
	// Use to enable/disable menu items
	@Override
	public void onPrepareOptionsMenu(Menu menu) {
		Log.i("TimelineFragment", "in onPrepareOptionsMenu()");
		if (mDoubleDrawer.isActionDrawerOpen()) {
			MenuItem item = menu.findItem(R.id.delete);
			item.setVisible(true);
			item = menu.findItem(R.id.edit);
			item.setVisible(true);
			item = menu.findItem(R.id.add);
			item.setVisible(false);
		} else {
			MenuItem item = menu.findItem(R.id.delete);
			item.setVisible(false);
			item = menu.findItem(R.id.edit);
			item.setVisible(false);
			item = menu.findItem(R.id.add);
			item.setVisible(true);
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Log.i("TimelineFragment", "in onOptionsItemSelected()");
		switch (item.getItemId()) {
		case R.id.add:
			Toast.makeText(mActivity, "Add clicked", Toast.LENGTH_SHORT).show();
			break;
		default:
			return false;
		}

		return true;
	}

	@Override
	public void onListItemClick(ListView list, View v, int pos, long id) {

		String thingClicked = (String) list.getItemAtPosition(pos);
		
		//Get action drawer
		setActionDrawer(R.layout.timeline_action_drawer_uneditable);
		ViewGroup actionDrawer = mDoubleDrawer.getActionDrawer();
		
		LayoutInflater inflater = mActivity.getLayoutInflater();
		actionDrawer.removeAllViews();

		mActionDrawer = inflater.inflate(
				R.layout.timeline_action_drawer_uneditable, 
				actionDrawer);
		
		TextView title = (TextView) mActionDrawer.findViewById(R.id.title_entry);
		title.setText(thingClicked);
		 
		TextView category = (TextView) mActionDrawer.findViewById(R.id.category_entry);
		category.setText("hard coded category");
		
		TextView date_button = (TextView) mActionDrawer.findViewById(R.id.date_button);
		date_button.setText("hard coded date");
				
		//open drawer
		mDoubleDrawer.getDrawerLayout().openDrawer(actionDrawer);
	}
	
	private void setActionDrawer(int layoutId) {
		ViewGroup actionDrawer = mDoubleDrawer.getActionDrawer();
		
		LayoutInflater inflater = mActivity.getLayoutInflater();
		actionDrawer.removeAllViews();

		mActionDrawer = inflater.inflate(layoutId, actionDrawer);
	}
}
