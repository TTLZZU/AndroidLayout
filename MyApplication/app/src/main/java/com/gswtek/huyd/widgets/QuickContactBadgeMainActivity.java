package com.gswtek.huyd.widgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.QuickContactBadge;

import com.gswtek.huyd.androidapipro.R;

/**
 * 关联联系人
 */
public class QuickContactBadgeMainActivity extends AppCompatActivity {
	private QuickContactBadge badge;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quick_contact_badge_main);

//        获取QuickContactBadge组件
		badge = (QuickContactBadge) findViewById(R.id.badge);
//        将QuickContactBadge组件与特定电话号码对应的联系人建立联系
		badge.assignContactFromPhone("15250037651", false);
	}

}
