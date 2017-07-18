package com.gswtek.huyd.imagesmedia;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.gswtek.huyd.androidapipro.R;
import com.gswtek.huyd.utils.Utils;

import java.io.File;

public class VideoViewMainActivity extends AppCompatActivity {

	private VideoView videoView;
	MediaController mediaco;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video_view_main);
		//本地的视频  需要在手机SD卡根目录添加一个 1.mp4 视频
		String videoUrl1 = Environment.getExternalStorageDirectory().getPath() + "/1.mp4";

		//网络视频
		String videoUrl2 = Utils.videoUrl;

		Uri uri;
		String str[] = videoUrl1.split("/");
		if (str[str.length - 1].equals("1.mp4")) {
			uri = Uri.parse(videoUrl1);
		} else {
			uri = Uri.parse(videoUrl2);
		}

		videoView = (VideoView) this.findViewById(R.id.videoView);

		//设置视频控制器
		videoView.setMediaController(new MediaController(this));

		//播放完成回调
		videoView.setOnCompletionListener(new MyPlayerOnCompletionListener());

		//设置视频路径
		videoView.setVideoURI(uri);

		//开始播放视频
		videoView.start();
	}

	class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {

		@Override
		public void onCompletion(MediaPlayer mp) {
			Toast.makeText(VideoViewMainActivity.this, "播放完成了", Toast.LENGTH_SHORT).show();
		}
	}

}
