package com.gswtek.huyd.datetime;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import com.gswtek.huyd.androidapipro.R;

public class ChronormeterMainActivity extends AppCompatActivity {
	private Chronometer chmt;
	private Button btnStart;
	private Button btnStop;
	private Button btnReset;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chronormeter_main);

		chmt = (Chronometer) findViewById(R.id.chmt);
		btnStart = (Button) findViewById(R.id.btnStart);
		btnStop = (Button) findViewById(R.id.btnStop);
		btnReset = (Button) findViewById(R.id.btnReset);

		chmt.setFormat("计时:%s");
		btnStart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				chmt.start();
			}
		});
		btnStop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				chmt.stop();
			}
		});
		btnReset.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				chmt.setBase(SystemClock.elapsedRealtime());
			}
		});
	}
}
