package com.gswtek.huyd.datetime;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextClock;
import android.widget.TextView;

import com.gswtek.huyd.androidapipro.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TextClockMainActivity extends AppCompatActivity {
	private TextClock textClock;
	private TextView tvSystemTime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text_clock_main);

		textClock = (TextClock) findViewById(R.id.textClock);
		tvSystemTime = (TextView) findViewById(R.id.tvSystemTime);

		new TimeHandler().getTime();


	}

	class TimeHandler extends Thread {
		//		private Handler handler = new Handler() {
//			@Override
//			public void handleMessage(Message msg) {
//				super.handleMessage(msg);
//				switch (msg.what) {
//					case 1:
//						long sysTime = System.currentTimeMillis();
//						CharSequence charSequence = DateFormat.format("hh:mm:ss", sysTime);
//						tvSystemTime.setText(charSequence);
//						break;
//					default:
//						break;
//				}
//			}
//		};
		Handler handler = new Handler();

		private void getTime() {
			Timer timer = new Timer();
			TimerTask timerTask = new TimerTask() {
				@Override
				public void run() {
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
					final String time = simpleDateFormat.format(new Date());
					handler.post(new Runnable() {
						@Override
						public void run() {
							tvSystemTime.setText(time);
						}
					});
				}
			};
			timer.schedule(timerTask, 0, 1000);//1秒
		}
	}
}
