package com.gswtek.huyd.widgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.gswtek.huyd.androidapipro.R;

public class SpinnerMainActivity extends AppCompatActivity {
	private Spinner spSpinner;
	private TextView tvSpinner;
	private ArrayAdapter<String> adapter;
	String[] data = {"北京", "上海", "深圳", "苏州"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spinner_main);

		initViews();


		//将可选内容与ArrayAdapter连接起来
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);

		//设置下拉列表的风格
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//将adapter 添加到spinner中
		spSpinner.setAdapter(adapter);
		//添加事件Spinner事件监听
		spSpinner.setOnItemSelectedListener(new SpinnerSelectedListener());

		//设置默认值
		spSpinner.setVisibility(View.VISIBLE);


	}

	//使用数组形式操作
	class SpinnerSelectedListener implements AdapterView.OnItemSelectedListener {


		@Override
		public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
			tvSpinner.setText(data[i]);
		}

		@Override
		public void onNothingSelected(AdapterView<?> adapterView) {

		}
	}

	private void initViews() {
		spSpinner = (Spinner) findViewById(R.id.spSpinner);
		tvSpinner = (TextView) findViewById(R.id.tvSpinner);


	}


}
