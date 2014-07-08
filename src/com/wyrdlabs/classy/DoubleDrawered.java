package com.wyrdlabs.classy;

import android.support.v4.widget.DrawerLayout;
import android.view.ViewGroup;

public interface DoubleDrawered {
	
	public ViewGroup getNavDrawer();
	public ViewGroup getActionDrawer();
	public DrawerLayout getDrawerLayout();


}
