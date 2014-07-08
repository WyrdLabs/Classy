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
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class TimelineFragment extends ListFragment {

	public static String TITLE = "Timeline";
	
	private Activity mActivity;
	private View mActionDrawer;
	
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
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.i("TimelineFragment", "in onCreateView()");
		
		View view = inflater.inflate(R.layout.timeline, container, false);
		
		return view;
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		Log.i("TimelineFragment", "in onAttach()");
		
		//Save activity
		mActivity = activity;
		
		//Attach data
		ListAdapter adapter = new ArrayAdapter<String>(activity, 
													   R.layout.timeline_item, 
													   R.id.event_title, 
													   new ArrayList<String>() {{
														   add("e1"); add("e2");
														   add("e3"); add("e4");
													   }});
		
		setListAdapter(adapter);
		
		//Change activity UI
		
		//Setup action drawer
		LayoutInflater inflater = activity.getLayoutInflater();
		ViewGroup actionDrawerViewGroup = ((DoubleDrawered) activity).getActionDrawer();
		actionDrawerViewGroup.removeAllViews();
		
		mActionDrawer = inflater.inflate(R.layout.timeline_action_drawer, actionDrawerViewGroup);
		
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
	}
	
	//Add this fragment's menu items
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		Log.i("TimelineFragment", "in onCreateOptionsMenu()");
		inflater.inflate(R.menu.timeline, menu);
	}
	
	//Called right before the menu is shown, every time it is shown
	//Use to enable/disable menu items
	@Override
	public void onPrepareOptionsMenu(Menu menu) {
		Log.i("TimelineFragment", "in onPrepareOptionsMenu()");
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Log.i("TimelineFragment", "in onOptionsItemSelected()");
	
		switch(item.getItemId()) {
			case R.id.add:		
				EditText et = (EditText) mActionDrawer.findViewById(R.id.et);
				TextView tv = (TextView) mActionDrawer.findViewById(R.id.tv);
				
				tv.setText(et.getText());
				
				et.setVisibility(View.GONE);
				tv.setVisibility(View.VISIBLE);
				
				Toast.makeText(mActivity, "Add clicked", Toast.LENGTH_SHORT)
					 .show();
				break;
			default:
				return false;
		}
		
		return true;
	}
	
}
