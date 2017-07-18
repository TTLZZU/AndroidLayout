package com.gswtek.huyd.containers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.gswtek.huyd.androidapipro.R;

import static android.view.KeyEvent.KEYCODE_BACK;

public class WebViewMainActivity extends AppCompatActivity {

	private WebView webView;
	private TextView titleView;

	//定义返回键为后退网页
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KEYCODE_BACK) && webView.canGoBack()) {
			webView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view_main);

		titleView = (TextView) findViewById(R.id.titleView);
		webView = (WebView) findViewById(R.id.webview);
		webView.canGoBack();
		webView.loadUrl("http://www.baidu.com/");
		//使用内置页面打开
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;

			}
		});
		//打开网页时定义滑动条
		webView.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				//get the newProgress and refresh progress bar
			}
		});
		//设置网页标题
		webView.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onReceivedTitle(WebView view, String title) {
				titleView.setText(title);//a textview
			}
		});

	}
}
