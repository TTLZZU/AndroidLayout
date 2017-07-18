package com.gswtek.huyd.datetime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

import com.gswtek.huyd.androidapipro.R;

public class TimePickerMainActivity extends AppCompatActivity {
	private TimePicker timePicker;
	private TextView tvTimePicker;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_time_picker_main);

		timePicker = (TimePicker) findViewById(R.id.timePicker);
		tvTimePicker = (TextView) findViewById(R.id.tvTimePicker);

		timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
			@Override
			public void onTimeChanged(TimePicker timePicker, int i, int i1) {
				tvTimePicker.setText("当前选择时间为：" + i + "时" + i1 + "分");
			}
		});

	}
}
