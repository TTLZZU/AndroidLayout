package com.gswtek.huyd.containers;

import android.app.TabActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

import com.gswtek.huyd.androidapipro.R;

public class TabHostMainActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_tab_host_main);

		// 得到TabActivity中的TabHost对象
		TabHost tabHost = getTabHost();

		// 内容：采用布局文件中的布局
		LayoutInflater.from(this).inflate(R.layout.activity_tab_host_main,
				tabHost.getTabContentView(), true);

		// 加上标签
		// 参数设置：新增的TabSpec的标签，标签中显示的字样
		// setContent设置内容对应的View资源标号
		tabHost.addTab(tabHost.newTabSpec("tab1")
				.setIndicator("tab1").setContent(R.id.view1));
		tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("tab2")
				.setContent(R.id.view2));
		tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("tab3")
				.setContent(R.id.view3));
	}
}
