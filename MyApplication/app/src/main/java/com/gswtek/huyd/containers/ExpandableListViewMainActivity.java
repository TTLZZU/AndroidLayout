package com.gswtek.huyd.containers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.gswtek.huyd.androidapipro.R;

import java.util.ArrayList;
import java.util.List;

public class ExpandableListViewMainActivity extends AppCompatActivity {
	ExpandableListView sp_date_list = null;     //列表
	MyExpandAdapter adapter = null;             //数据适配器

	List<String> group_head;                    //组列表项，每个组都有一个子List
	List<List<String>> child;                   //子列表项

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expandable_list_view_main);

		//获取控件
		sp_date_list = (ExpandableListView) findViewById(R.id.expandableListView_plan_manager);
		//初始化组、子列表项
		group_head = new ArrayList<String>();
		child = new ArrayList<List<String>>();

		//设置适配器
		sp_date_list.setAdapter(new MyExpandAdapter(group_head, this, child)); //设置数据适配器
		sp_date_list.setCacheColorHint(0);              //拖动列表的时候不出现黑色背景

		addGroup("Java");
		addGroup("Android");
		addChild(0, "面向对象");
		addChild(0, "封装");
		addChild(0, "继承");
		addChild(0, "多态");
		addChild(1, "移动端");
		addChild(1, "Java");
		addChild(1, "Kotlin");
	}

	//添加组列表项
	public void addGroup(String group) {
		group_head.add(group);
		child.add(new ArrayList<String>()); //child中添加新数组
	}

	//添加对应组的自列表项
	public void addChild(int position, String child) {
		List<String> it = this.child.get(position);
		if (it != null) {
			it.add(child);
		} else {
			it = new ArrayList<String>();
			it.add(child);
		}
	}

	//子列表项被选中的响应方法
	public void childSelect(int groupPosition, int childPosition) {
//		Toast.makeText(getBaseContext(), Integer.toString(groupPosition) + ":" +
//				Integer.toString(childPosition), Toast.LENGTH_SHORT).show();
	}
}
