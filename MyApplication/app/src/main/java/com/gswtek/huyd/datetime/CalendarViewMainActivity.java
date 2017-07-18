package com.gswtek.huyd.datetime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import com.gswtek.huyd.androidapipro.R;

public class CalendarViewMainActivity extends AppCompatActivity {
	private CalendarView calendarView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendar_view_main);

		calendarView = (CalendarView) findViewById(R.id.calendarView);

		calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
			@Override
			public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
				Toast.makeText(CalendarViewMainActivity.this, "当前的日期为:" + i + "年" + i1 + "月" + i2 + "日", Toast.LENGTH_SHORT).show();
			}
		});
	}
}
