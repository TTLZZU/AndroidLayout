package com.gswtek.huyd.widgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ListView;

import com.gswtek.huyd.androidapipro.R;

public class CheckedTVMainActivity extends AppCompatActivity {
	private CheckedTextView ctv1;
	private CheckedTextView ctv2;
	private CheckedTextView ctv3;
	private CheckedTextView ctv4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_checked_tvmain);

		initViews();

		//设置checkedTextView1为选中状态
		ctv1.setChecked(true);
//设置checkedTextView2的页边距，即距上/下/左/右各20像素，默认为未选中状态
		ctv2.setPadding(20, 20, 20, 20);
//设置checkedTextView3为选中状态，并更改其显示图标，使用android系统资源arrow_down_float
		ctv3.setChecked(true);
		ctv3.setCheckMarkDrawable(android.R.drawable.arrow_down_float);
//设置checkedTextView4反转状态，由默认的未选中反转为选中状态
		ctv4.toggle();
//点击状态后变更相反，如选中变为未选中，未选中的变为选中
		ctv1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ctv1.toggle();
			}
		});

//点击状态后变更相反，如选中变为未选中，未选中的变为选中
		ctv2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ctv2.toggle();
			}
		});


		//点击状态后变更相反，即下三角转化为上三角符号
		ctv3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ctv3.setCheckMarkDrawable(android.R.drawable.arrow_up_float);
			}

		});

		//点击状态后变更相反，如选中变为未选中，未选中的变为选中
		ctv4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ctv4.toggle();
			}
		});


	}

	private void initViews() {
		ctv1 = (CheckedTextView) findViewById(R.id.ctv1);
		ctv2 = (CheckedTextView) findViewById(R.id.ctv2);
		ctv3 = (CheckedTextView) findViewById(R.id.ctv3);
		ctv4 = (CheckedTextView) findViewById(R.id.ctv4);
	}
}
