package com.gswtek.huyd.widgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import com.gswtek.huyd.androidapipro.R;

public class RatingBarMainActivity extends AppCompatActivity {
	private RatingBar ratingBar;
	private TextView tvRatingBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rating_bar_main);

		ratingBar = (RatingBar) findViewById(R.id.rbRatingBar);
		tvRatingBar = (TextView) findViewById(R.id.tvRatingBar);
		ratingBar.setOnRatingBarChangeListener(new ratingChangeListener());
	}

	class ratingChangeListener implements RatingBar.OnRatingBarChangeListener {

		@Override
		public void onRatingChanged(RatingBar ratingBar, float rating,
		                            boolean fromUser) {
			// TODO Auto-generated method stub
			if (fromUser) {
				System.out.println("onRatingChanged " + rating);
			}
			tvRatingBar.setText("当前的值为：" + rating);
		}

	}
}
