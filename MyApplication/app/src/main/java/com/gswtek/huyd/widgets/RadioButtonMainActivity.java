package com.gswtek.huyd.widgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.gswtek.huyd.androidapipro.R;

public class RadioButtonMainActivity extends AppCompatActivity {
	private RadioButton rbMan;
	private RadioButton rbWoman;
	private TextView tvRadioButton;
	private RadioGroup radgroup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_radio_button_main);

		initViews();
		//为radioGroup设置一个监听器:setOnCheckedChanged()
		radgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				RadioButton radbtn = (RadioButton) findViewById(checkedId);
				tvRadioButton.setText(radbtn.getText());
			}
		});
	}

	private void initViews() {
		rbMan = (RadioButton) findViewById(R.id.btnMan);
		rbWoman = (RadioButton) findViewById(R.id.btnWoman);
		tvRadioButton = (TextView) findViewById(R.id.tvRadioButton);
		radgroup = (RadioGroup) findViewById(R.id.radioGroup);
	}
}
