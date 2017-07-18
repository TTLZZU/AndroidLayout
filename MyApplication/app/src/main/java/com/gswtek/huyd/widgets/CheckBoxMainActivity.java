package com.gswtek.huyd.widgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.gswtek.huyd.androidapipro.R;

public class CheckBoxMainActivity extends AppCompatActivity {
	private CheckBox cbCheckBox;
	private TextView tvCheckBox;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_box_main);

		cbCheckBox = (CheckBox) findViewById(R.id.cbCheckBox);
		tvCheckBox = (TextView) findViewById(R.id.tvCheckBox);

		cbCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
				if (b == true) {
					tvCheckBox.setText("已选中");
				} else {
					tvCheckBox.setText("未选中");
				}
			}
		});
	}
}
