package com.hungnt.login_register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends Activity implements View.OnClickListener {

    public static final int GET_REQUEST_CODE = 1;
    public static final String EXTRA_EMAIL = "com.hungnt.login_register.email";

    Button bLogin;
    EditText etUsername,etPassword;
    TextView btRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btRegister = (TextView) findViewById(R.id.tvRegister);

        etPassword = (EditText) findViewById(R.id.etPassword);
        etUsername = (EditText) findViewById(R.id.etEmail);

        bLogin = (Button) findViewById(R.id.bLogin);

        btRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bLogin:
                break;
            case R.id.tvRegister:
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                intent.putExtra(EXTRA_EMAIL,etUsername.getText().toString());
                startActivityForResult(intent, GET_REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.i("LoginAct","onActivityResult");
        if(requestCode == GET_REQUEST_CODE)
            if(resultCode==RESULT_OK) {
                etUsername.setText(data.getStringExtra("email"));
                etPassword.setText("");
            }
    }
}
