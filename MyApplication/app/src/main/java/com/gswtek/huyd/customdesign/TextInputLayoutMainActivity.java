package com.gswtek.huyd.customdesign;

import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gswtek.huyd.androidapipro.R;

public class TextInputLayoutMainActivity extends AppCompatActivity implements View.OnClickListener {
	private EditText input_name, input_password, input_email;
	private TextInputLayout layout_name, layout_password, layout_email;
	private Button btn_login;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text_input_layout_main);

		initWidget();


	}

	private void initWidget() {
		input_name = (EditText) findViewById(R.id.input_name);
		input_password = (EditText) findViewById(R.id.input_password);
		input_email = (EditText) findViewById(R.id.input_email);

		layout_name = (TextInputLayout) findViewById(R.id.layout_name);
		layout_password = (TextInputLayout) findViewById(R.id.layout_password);
		layout_email = (TextInputLayout) findViewById(R.id.layout_email);

		btn_login = (Button) findViewById(R.id.login);
		btn_login.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.login:
				canLogin();
				break;
			default:
				break;

		}
	}

	/**
	 * 判断是否可以登录的方法
	 */
	private void canLogin() {
		if (!isNameValid()) {
			Toast.makeText(this, getString(R.string.check), Toast.LENGTH_SHORT).show();
			return;
		}
		if (!isPasswordValid()) {
			Toast.makeText(this, getString(R.string.check), Toast.LENGTH_SHORT).show();
			return;
		}
		if (!isEmailValid()) {
			Toast.makeText(this, getString(R.string.check), Toast.LENGTH_SHORT).show();
			return;
		}
		Toast.makeText(this, getString(R.string.login_success), Toast.LENGTH_SHORT).show();
	}

	public boolean isNameValid() {

		if (input_name.getText().toString().trim().equals("") || input_name.getText().toString().trim().isEmpty()) {
			layout_name.setError(getString(R.string.error_name));
			input_name.requestFocus();
			return false;
		}
		layout_name.setErrorEnabled(false);
		return true;
	}

	public boolean isPasswordValid() {
		if (input_password.getText().toString().trim().equals("") || input_password.getText().toString().trim().isEmpty()) {
			layout_password.setErrorEnabled(true);
			layout_password.setError(getResources().getString(R.string.error_password));
			input_password.requestFocus();
			return false;
		}
		layout_password.setErrorEnabled(false);
		return true;
	}

	public boolean isEmailValid() {
		String email = input_email.getText().toString().trim();
		if (TextUtils.isEmpty(email) || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
			layout_email.setErrorEnabled(true);
			layout_email.setError(getString(R.string.error_email));
			layout_email.requestFocus();
			return false;
		}
		layout_email.setErrorEnabled(false);
		return true;
	}
}
