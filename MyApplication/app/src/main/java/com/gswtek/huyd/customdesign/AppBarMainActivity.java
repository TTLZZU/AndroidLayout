package com.gswtek.huyd.customdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.gswtek.huyd.androidapipro.R;

public class AppBarMainActivity extends AppCompatActivity {
	private Toolbar toolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_app_bar_main);

		toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolbar.setTitle("标题");
		toolbar.setSubtitle("子标题");
		toolbar.setLogo(R.mipmap.ic_launcher);
		setSupportActionBar(toolbar);
	}
}
