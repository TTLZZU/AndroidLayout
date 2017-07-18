package com.gswtek.huyd.widgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.gswtek.huyd.androidapipro.R;

public class ToggleButtonMainActivity extends AppCompatActivity {
	private ToggleButton toggleButton;
	private TextView tvToggleButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_toggle_button_main);

		initViews();

		toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
				if (b) {
					tvToggleButton.setText("打开");
				} else {
					tvToggleButton.setText("关闭");
				}
			}
		});

	}

	private void initViews() {
		toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
		tvToggleButton = (TextView) findViewById(R.id.tvToggleButton);
	}
}
