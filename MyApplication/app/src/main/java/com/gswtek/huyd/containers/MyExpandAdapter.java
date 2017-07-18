package com.gswtek.huyd.containers;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.gswtek.huyd.androidapipro.R;

import java.util.List;

/**
 * Author: huyd
 * Date: 2017-07-07
 * Time: 15:14
 * Describe:
 */
public class MyExpandAdapter extends BaseExpandableListAdapter {
	List<String> group_head;
	List<List<String>> child;
	ExpandableListViewMainActivity context;

	public MyExpandAdapter(List<String> group_head, ExpandableListViewMainActivity context, List<List<String>> child) {
		this.group_head = group_head;
		this.context = context;
		this.child = child;
	}

	@Override
	public int getGroupCount() {
		return this.group_head.size();
	}

	@Override
	public int getChildrenCount(int i) {
		if (i < 0 || i >= this.child.size())
			return 0;
		return child.get(i).size();
	}

	@Override
	public Object getGroup(int i) {
		return group_head.get(i);
	}

	@Override
	public Object getChild(int i, int i1) {
		return child.get(i1).get(i1);
	}

	@Override
	public long getGroupId(int i) {
		return i;
	}

	@Override
	public long getChildId(int i, int i1) {
		return i1;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
		//获取文本
		String text = group_head.get(i);
		if (view == null) {
			//组列表界面只有一个文本框，直接生成
			view = new TextView(context);
			//设定界面，AbsListView:用于实现条目的虚拟列表的基类
			AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
					ViewGroup.LayoutParams.FILL_PARENT, 60);
			((TextView) view).setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT); //文本框放在中央
			view.setPadding(45, 0, 0, 0);                               //设置文本里那个下拉的图标远一点
			view.setLayoutParams(lp);
			Log.d("Group", text);
		}
		((TextView) view).setText(text);
		return view;
	}

	@Override
	public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
		//子列表控件通过界面文件设计
		if (view == null) {//convert在运行中会重用，如果不为空，则表明不用重新获取
			LayoutInflater layoutInflater;//使用这个来载入界面
			layoutInflater = LayoutInflater.from(context);
			view = layoutInflater.inflate(R.layout.plain_text, null);
		}
		TextView tv = (TextView) view.findViewById(R.id.textView_plain_text);
		String text = child.get(i).get(i1);
		tv.setText(text);
		//获取文本控件，并设置值
		return view;
	}

	@Override
	public boolean isChildSelectable(int i, int i1) {
		//调用Activity里的ChildSelect方法
		context.childSelect(i,i1);
		return true;
	}
}
