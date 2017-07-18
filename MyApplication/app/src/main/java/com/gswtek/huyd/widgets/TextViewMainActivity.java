package com.gswtek.huyd.widgets;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gswtek.huyd.androidapipro.R;

public class TextViewMainActivity extends AppCompatActivity implements View.OnClickListener {
	private Button btnTVBig;
	private Button btnTVSmall;
	private Button btnTVRed;
	private Button btnTVChange;
	private TextView tvFontChange;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text_view_main);

		initViews();//初始化View
	}

	private void initViews() {
		btnTVBig = (Button) findViewById(R.id.btnTVBig);
		btnTVSmall = (Button) findViewById(R.id.btnTVSmall);
		btnTVRed = (Button) findViewById(R.id.btnTVRed);
		btnTVChange = (Button) findViewById(R.id.btnTVChange);
		tvFontChange = (TextView) findViewById(R.id.tvFontChange);

		btnTVBig.setOnClickListener(this);
		btnTVSmall.setOnClickListener(this);
		btnTVRed.setOnClickListener(this);
		btnTVChange.setOnClickListener(this);

	}

	@RequiresApi(api = 26)
	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.btnTVBig:
				tvFontChange.setTextSize(TypedValue.COMPLEX_UNIT_PX, 120);
				break;
			case R.id.btnTVSmall:
				tvFontChange.setTextSize(TypedValue.COMPLEX_UNIT_PX, 50);
				break;
			case R.id.btnTVRed:
				tvFontChange.setTextColor(Color.rgb(255, 0, 0));
				break;
			case R.id.btnTVChange:
				tvFontChange.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
				break;
		}
	}
}
