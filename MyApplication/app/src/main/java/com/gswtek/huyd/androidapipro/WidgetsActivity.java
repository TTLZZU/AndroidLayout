package com.gswtek.huyd.androidapipro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.gswtek.huyd.widgets.ButtonMainActivity;
import com.gswtek.huyd.widgets.CheckBoxMainActivity;
import com.gswtek.huyd.widgets.CheckedTVMainActivity;
import com.gswtek.huyd.widgets.ProgressBarMainActivity;
import com.gswtek.huyd.widgets.QuickContactBadgeMainActivity;
import com.gswtek.huyd.widgets.RadioButtonMainActivity;
import com.gswtek.huyd.widgets.RatingBarMainActivity;
import com.gswtek.huyd.widgets.SeekBarMainActivity;
import com.gswtek.huyd.widgets.SpaceMainActivity;
import com.gswtek.huyd.widgets.SpinnerMainActivity;
import com.gswtek.huyd.widgets.TextViewMainActivity;
import com.gswtek.huyd.widgets.ToggleButtonMainActivity;

import java.util.ArrayList;
import java.util.List;

public class WidgetsActivity extends AppCompatActivity {
	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_widgets);

		listView = (ListView) findViewById(R.id.widgetsListView);
		//我们设置一个List集合，然后向里边添加几条数据
		List<String> ls = new ArrayList<String>();
		ls.add("TextView");
		ls.add("Button");
		ls.add("ToggleButton");
		ls.add("CheckBox");
		ls.add("RadioButton");
		ls.add("CheckedTextView");
		ls.add("Spinner");
		ls.add("ProgressBar");
		ls.add("SeekBar");
		ls.add("QuickContactBadge");
		ls.add("RatingBar");
		ls.add("Space");

		//获取xml文件中listView控件
		//然后为listView控件调用setAdapter方法，让数据显示在界面上。
		listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ls));

		//为listView对象进行监听：当点击子项目的时候触发
		listView.setOnItemClickListener(new ItemClickEvent());
	}

	//继承OnItemClickListener，当子项目被点击的时候触发
	private final class ItemClickEvent implements AdapterView.OnItemClickListener {
		//这里需要注意的是第三个参数arg2，这是代表单击第几个选项
		@Override
		public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
			//通过单击事件，获得单击选项的内容
			String text = listView.getItemAtPosition(i) + "";
			//通过吐丝对象显示出来。
			Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
			if (demos.length > i) {
				Intent intent = new Intent(WidgetsActivity.this, demos[i].demoClass);
				startActivity(intent);
			}

		}
	}

	//把每个activity转成class
	private static class DemoInfo {
		private final Class<? extends android.app.Activity> demoClass;

		public DemoInfo(Class<? extends android.app.Activity> demoClass) {
			this.demoClass = demoClass;
		}
	}

	//把每个activity转成xxx.class
	private static final DemoInfo[] demos = {
			new DemoInfo(TextViewMainActivity.class),
			new DemoInfo(ButtonMainActivity.class),
			new DemoInfo(ToggleButtonMainActivity.class),
			new DemoInfo(CheckBoxMainActivity.class),
			new DemoInfo(RadioButtonMainActivity.class),
			new DemoInfo(CheckedTVMainActivity.class),
			new DemoInfo(SpinnerMainActivity.class),
			new DemoInfo(ProgressBarMainActivity.class),
			new DemoInfo(SeekBarMainActivity.class),
			new DemoInfo(QuickContactBadgeMainActivity.class),
			new DemoInfo(RatingBarMainActivity.class),
			new DemoInfo(SpaceMainActivity.class),
	};
}

