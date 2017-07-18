package com.gswtek.huyd.datetime;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gswtek.huyd.androidapipro.R;

import java.util.Calendar;

public class DatePickerMainActivity extends AppCompatActivity {
	private DatePicker datePicker;
	private TextView tvDatePicker;
	// 定义5个记录当前时间的变量
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_date_picker_main);

		datePicker = (DatePicker) findViewById(R.id.datePicker);
		tvDatePicker = (TextView) findViewById(R.id.tvDatePicker);

		// 获取当前的年、月、日、小时、分钟
		Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
		hour = c.get(Calendar.HOUR);
		minute = c.get(Calendar.MINUTE);
		// 初始化DatePicker组件，初始化时指定监听器
		datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {

			@Override
			public void onDateChanged(DatePicker arg0, int year
					, int month, int day) {
				DatePickerMainActivity.this.year = year;
				DatePickerMainActivity.this.month = month;
				DatePickerMainActivity.this.day = day;
				// 显示当前日期、时间
				showDate(year, month, day, hour, minute);
				Toast.makeText(DatePickerMainActivity.this, "您选择的日期：" + year + "年  "
						+ month + "月  " + day + "日", Toast.LENGTH_SHORT).show();
			}
		});
	}

	// 定义在EditText中显示当前日期、时间的方法
	private void showDate(int year, int month
			, int day, int hour, int minute) {
		tvDatePicker.setText("您选择的日期和时间为：" + year + "年"
				+ (month + 1) + "月" + day + "日  "
				+ hour + "时" + minute + "分");
	}
}
