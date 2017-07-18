package com.gswtek.huyd.imagesmedia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.gswtek.huyd.androidapipro.R;

public class ImageButtonMainActivity extends AppCompatActivity {
	private ImageButton imgBtn;
	private TextView tvImgBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_button_main);

		imgBtn = (ImageButton) findViewById(R.id.imgBtn);
		tvImgBtn = (TextView) findViewById(R.id.tvImgBtn);

		imgBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				tvImgBtn.setText("你点击了！");
			}
		});
	}
}
