package com.gswtek.huyd.customdesign;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import com.gswtek.huyd.androidapipro.R;

public class TabLayoutMainActivity extends AppCompatActivity {
	private TabLayout mTabLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab_layout_main);

//		mTabLayout = (TabLayout) findViewById(R.id.tab_layout2);
//
//		mTabLayout.addTab(mTabLayout.newTab().setText("微信"));
//		mTabLayout.addTab(mTabLayout.newTab().setText("通讯录"));
//		mTabLayout.addTab(mTabLayout.newTab().setText("发现"));
//		mTabLayout.addTab(mTabLayout.newTab().setText("发现"));
//		mTabLayout.addTab(mTabLayout.newTab().setText("我"));
	}
}
