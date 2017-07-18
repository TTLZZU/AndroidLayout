package com.gswtek.huyd.widgets;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gswtek.huyd.androidapipro.R;

import static android.icu.text.RelativeDateTimeFormatter.Direction.NEXT;

public class ProgressBarMainActivity extends AppCompatActivity {
	private ProgressBar pbLarge;
	private ProgressBar pbMedium;
	private ProgressBar pbSmall;
	private ProgressBar pbHorizontal;
	private TextView tvLarge;
	private TextView tvMedium;
	private TextView tvSmall;
	private Button mButton;

	protected static final int STOP = 0x10000;
	protected static final int NEXT = 0x10001;
	private int iCount = 0;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_progress_bar_main);

		initViews();


		mButton.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View v) {

				pbHorizontal.setVisibility(View.VISIBLE);

				pbHorizontal.setMax(100);
				pbHorizontal.setProgress(0);

				//创建一个线程,每秒步长为5增加,到100%时停止
				Thread mThread = new Thread(new Runnable() {

					public void run() {

						for (int i = 0; i < 20; i++) {
							try {
								iCount = (i + 1) * 5;
								Thread.sleep(1000);
								if (i == 19) {
									Message msg = new Message();
									msg.what = STOP;
									mHandler.sendMessage(msg);
									break;
								} else {
									Message msg = new Message();
									msg.what = NEXT;
									mHandler.sendMessage(msg);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}

					}
				});
				mThread.start();
			}
		});


	}

	//定义一个Handler
	private Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case STOP:
					pbHorizontal.setVisibility(View.GONE);
					Thread.currentThread().interrupt();
					break;
				case NEXT:
					if (!Thread.currentThread().isInterrupted()) {
						pbHorizontal.setProgress(iCount);
					}
					break;
			}
		}
	};

	private void initViews() {
		pbLarge = (ProgressBar) findViewById(R.id.pbLarge);
		pbMedium = (ProgressBar) findViewById(R.id.pbMedium);
		pbSmall = (ProgressBar) findViewById(R.id.pbSmall);
		pbHorizontal = (ProgressBar) findViewById(R.id.pbHorizontal);

		tvLarge = (TextView) findViewById(R.id.tvLarge);
		tvMedium = (TextView) findViewById(R.id.tvMedium);
		tvSmall = (TextView) findViewById(R.id.tvSmall);

		mButton = (Button) findViewById(R.id.btnProgressBar);
	}
}
