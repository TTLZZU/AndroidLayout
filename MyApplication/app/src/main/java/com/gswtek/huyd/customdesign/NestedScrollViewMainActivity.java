package com.gswtek.huyd.customdesign;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gswtek.huyd.androidapipro.R;

import java.util.ArrayList;
import java.util.List;

public class NestedScrollViewMainActivity extends AppCompatActivity {
	List<String> mData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nested_scroll_view_main);
		initData(1);
		initView();
	}

	private void initData(int pager) {
		mData = new ArrayList<>();
		for (int i = 1; i < 50; i++) {
			mData.add("pager" + pager + " 第" + i + "个item");
		}
	}

	private void initView() {
		//设置ToolBar
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolbar.setTitle("");
		toolbar.setNavigationIcon(R.mipmap.tab_better_normal);
		setSupportActionBar(toolbar);//替换系统的actionBar

		//设置TabLayout
		TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
		for (int i = 1; i < 20; i++) {
			tabLayout.addTab(tabLayout.newTab().setText("TAB" + i));
		}
		//TabLayout的切换监听
		tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				initData(tab.getPosition() + 1);
				setScrollViewContent();
			}

			@Override
			public void onTabUnselected(TabLayout.Tab tab) {

			}

			@Override
			public void onTabReselected(TabLayout.Tab tab) {

			}
		});
		setScrollViewContent();
	}

	/**
	 * 刷新ScrollView的内容
	 */
	private void setScrollViewContent() {
		//NestedScrollView下的LinearLayout
		LinearLayout layout = (LinearLayout) findViewById(R.id.ll_sc_content);
		layout.removeAllViews();
		for (int i = 0; i < mData.size(); i++) {
			View view = View.inflate(NestedScrollViewMainActivity.this, R.layout.plain_text, null);
			((TextView) view.findViewById(R.id.textView_plain_text)).setText(mData.get(i));
			//动态添加 子View
			layout.addView(view, i);
		}
	}
}
