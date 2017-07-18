package com.gswtek.huyd.customdesign;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gswtek.huyd.androidapipro.R;


public class CoordinatorLayoutMainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_coordinator_layout_main);

		findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "FAB", Snackbar.LENGTH_LONG).setAction("cancel", new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						//这里的单击事件代表点击消除Action后的响应事件
					}
				}).show();
			}
		});
	}
}
