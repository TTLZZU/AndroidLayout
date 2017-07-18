package com.gswtek.huyd.customappcompat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gswtek.huyd.androidapipro.R;
import com.gswtek.huyd.model.News;

import java.util.ArrayList;
import java.util.List;

public class CardViewMainActivity extends AppCompatActivity {

	private RecyclerView recyclerView;
	private List<News> newsList;
	private RecyclerViewAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_card_view_main);

		LinearLayoutManager layoutManager = new LinearLayoutManager(this);


		recyclerView = (RecyclerView) findViewById(R.id.recycleview);

		initPersonData();
		adapter = new RecyclerViewAdapter(newsList, CardViewMainActivity.this);

		recyclerView.setLayoutManager(layoutManager);
		recyclerView.setHasFixedSize(true);
		recyclerView.setAdapter(adapter);


	}

	private void initPersonData() {
		newsList = new ArrayList<>();
		//添加新闻
		newsList.add(new News(getString(R.string.news_one_title), getString(R.string.news_one_desc), R.mipmap.banner));
		newsList.add(new News(getString(R.string.news_two_title), getString(R.string.news_two_desc), R.mipmap.banner));
		newsList.add(new News(getString(R.string.news_three_title), getString(R.string.news_three_desc), R.mipmap.banner));
		newsList.add(new News(getString(R.string.news_four_title), getString(R.string.news_four_desc), R.mipmap.banner));
	}
}
