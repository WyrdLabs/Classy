package com.wyrdlabs.classy;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TimelineFragment extends ListFragment {

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
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
	}
	
}
