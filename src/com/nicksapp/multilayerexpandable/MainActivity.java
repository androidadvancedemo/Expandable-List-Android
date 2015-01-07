package com.nicksapp.multilayerexpandable;

import java.util.ArrayList;


import com.startapp.android.publish.StartAppAd;
import com.startapp.android.publish.splash.SplashConfig;
import com.startapp.android.publish.splash.SplashConfig.Theme;

import android.app.ExpandableListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

public class MainActivity extends ExpandableListActivity implements
		OnChildClickListener {
View loadMoreView;
private StartAppAd startAppAd = new StartAppAd(this);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		StartAppAd.init(MainActivity.this, "103205820", "203170552");
		super.onCreate(savedInstanceState);
		
		
		StartAppAd.showSplash(this, savedInstanceState,
				new SplashConfig()
					.setTheme(Theme.SKY)
					.setLogo(R.drawable.ic_launcher)
					.setAppName("Expandable List")
		);
		ExpandableListView expandbleLis = getExpandableListView();
		expandbleLis.setDividerHeight(2);
		expandbleLis.setGroupIndicator(null);
		expandbleLis.setClickable(true);

		setGroupData();
		setChildGroupData();

		
		

		 StartAppAd.showSlider(this);
			startAppAd.loadAd(); // load the next ad
			
				startAppAd.showAd(); // show the ad
				startAppAd.loadAd(); // load the next ad
				
		NewAdapter mNewAdapter = new NewAdapter(groupItem, childItem);
		mNewAdapter
				.setInflater(
						(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE),
						this);
		
		expandbleLis.setOnChildClickListener(this);
		loadMoreView = ((LayoutInflater)MainActivity.this
			    .getSystemService(Context.LAYOUT_INFLATER_SERVICE))
			    .inflate(R.layout.loadmore, null, false);
		expandbleLis.addFooterView(loadMoreView);
		
		expandbleLis.setTextFilterEnabled(true);
		getExpandableListView().setAdapter(mNewAdapter);
	}

	public void setGroupData() {
		groupItem.add("Mobile");
		groupItem.add("TechNology");
		
		groupItem.add("Manufacturer");
		groupItem.add("Extras");
	}

	ArrayList<String> groupItem = new ArrayList<String>();
	ArrayList<Object> childItem = new ArrayList<Object>();

	public void setChildGroupData() {
		
		/**
		 * Add Data For Mobile
		 */
		ArrayList<String> child = new ArrayList<String>();
		child.add("Android");
		child.add("Window Mobile");
		child.add("iPHone");
		child.add("Blackberry");
		childItem.add(child);
		
		/**
		 * Add Data For TecthNology
		 */
		 child = new ArrayList<String>();
		child.add("Java");
		child.add("Drupal");
		child.add(".Net Framework");
		child.add("PHP");
		childItem.add(child);

		
		/**
		 * Add Data For Manufacture
		 */
		child = new ArrayList<String>();
		child.add("HTC");
		child.add("Apple");
		child.add("Samsung");
		child.add("Nokia");
		childItem.add(child);
		/**
		 * Add Data For Extras
		 */
		child = new ArrayList<String>();
		child.add("Contact Us");
		child.add("About Us");
		child.add("Location");
		child.add("Root Cause");
		childItem.add(child);
	}

	@Override
	public boolean onChildClick(ExpandableListView parent, View v,
			int groupPosition, int childPosition, long id) {
		Toast.makeText(MainActivity.this, "Clicked On Child",
				Toast.LENGTH_SHORT).show();
		
		startAppAd.showAd(); // show the ad
		startAppAd.loadAd(); // load the next ad
		return true;
	}
	
	@Override
		public void onBackPressed() {
			// TODO Auto-generated method stub
		startAppAd.onBackPressed();
			super.onBackPressed();
		}
}
