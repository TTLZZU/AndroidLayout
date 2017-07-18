package com.gswtek.huyd.widgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.gswtek.huyd.androidapipro.R;

public class SeekBarMainActivity extends AppCompatActivity {
	private SeekBar sb1;
	private SeekBar sb2;
	private TextView tvSeekBar1;
	private TextView tvSeekBar2;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seek_bar_main);

		initViews();

		//滑动条使用
		sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
				tvSeekBar1.setText("当前滑动的值为:" + Integer.toString(i));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}
		});

		//滑动条使用
		sb2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
				tvSeekBar2.setText("当前滑动的值为:" + Integer.toString(i));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}
		});

	}

	private void initViews() {
		sb1 = (SeekBar) findViewById(R.id.sbSeekBar1);
		sb2 = (SeekBar) findViewById(R.id.sbSeekBar2);

		tvSeekBar1 = (TextView) findViewById(R.id.tvSeekBar1);
		tvSeekBar2 = (TextView) findViewById(R.id.tvSeekBar2);
	}
}
