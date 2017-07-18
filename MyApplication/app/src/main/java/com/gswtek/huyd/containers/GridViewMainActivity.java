package com.gswtek.huyd.containers;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.gswtek.huyd.androidapipro.R;
import com.gswtek.huyd.model.Icon;

import java.util.ArrayList;
import java.util.HashMap;

public class GridViewMainActivity extends AppCompatActivity {
	private Context mContext;
	private GridView grid_photo;
	private int[] image = {R.mipmap.test1, R.mipmap.test2, R.mipmap.test3,
			R.mipmap.test1, R.mipmap.test2, R.mipmap.test3, R.mipmap.test1,
			R.mipmap.test2};
	private String[] text = {"a", "b", "c", "d", "e", "f", "g", "h"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid_view_main);

		//显示GridView的界面
		GridView gridview = (GridView) findViewById(R.id.grid_photo);
		ArrayList<HashMap<String, Object>> imagelist = new ArrayList<HashMap<String, Object>>();
		// 使用HashMap将图片添加到一个数组中，注意一定要是HashMap<String,Object>类型的，因为装到map中的图片要是资源ID，而不是图片本身
		// 如果是用findViewById(R.drawable.image)这样把真正的图片取出来了，放到map中是无法正常显示的
		for (int i = 0; i < 8; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("image", image[i]);
			map.put("text", text[i]);
			imagelist.add(map);
		}
		// 使用simpleAdapter封装数据，将图片显示出来
		// 参数一是当前上下文Context对象
		// 参数二是图片数据列表，要显示数据都在其中
		// 参数三是界面的XML文件，注意，不是整体界面，而是要显示在GridView中的单个Item的界面XML
		// 参数四是动态数组中与map中图片对应的项，也就是map中存储进去的相对应于图片value的key
		// 参数五是单个Item界面XML中的图片ID
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, imagelist,
				R.layout.item_grid_icon, new String[]{"image", "text"}, new int[]{
				R.id.img_icon, R.id.txt_icon});
		// 设置GridView的适配器为新建的simpleAdapter
		gridview.setAdapter(simpleAdapter);

		//点击Item，发生事件
		gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
				Toast.makeText(GridViewMainActivity.this, text[i], Toast.LENGTH_SHORT).show();
			}
		});
	}

}
