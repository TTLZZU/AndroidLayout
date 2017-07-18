package com.gswtek.huyd.widgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;

import com.gswtek.huyd.androidapipro.R;

public class ButtonMainActivity extends AppCompatActivity implements View.OnClickListener {
	private Button btnButtonSwitch;
	private Button btnButtonChange;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_button_main);

		initViews();

	}

	private void initViews() {
		btnButtonSwitch = (Button) findViewById(R.id.btnButtonSwitch);
		btnButtonChange = (Button) findViewById(R.id.btnButtonChange);

		btnButtonSwitch.setOnClickListener(this);
		btnButtonChange.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.btnButtonSwitch:
				if (btnButtonSwitch.getText().equals("打开")) {
					btnButtonSwitch.setText("关闭");
				} else {
					btnButtonSwitch.setText("打开");
				}
				break;
			case R.id.btnButtonChange:
				btnButtonChange.setTextSize(TypedValue.COMPLEX_UNIT_PX, 50);
				break;
		}
	}
}
