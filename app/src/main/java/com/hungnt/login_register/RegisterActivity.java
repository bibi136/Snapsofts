package com.hungnt.login_register;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class RegisterActivity extends Activity implements View.OnClickListener {

    Button bRegister;
    EditText etEmail;
    EditText etPassword;
    EditText etRepassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etRepassword = (EditText) findViewById(R.id.etRePassword);

        bRegister = (Button) findViewById(R.id.bRegister);

        //Get the data from intent
        Intent intent = getIntent();
        String email = intent.getStringExtra(LoginActivity.EXTRA_EMAIL);

        etEmail.setText(email);

        bRegister.setOnClickListener(this);

    }

    public void showAlert(View view) {
        Builder builder = new Builder(this);
        builder.setMessage("Password doesn't match!")
                .setTitle("Warning")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        builder.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bRegister:
                if (etPassword.getText().toString().equals(""));
                else if (etPassword.getText().toString().equals(etRepassword.getText().toString())) {
                    String email = etEmail.getText().toString();
                    Intent intent = getIntent();
                    intent.putExtra("email", email);
                    setResult(RESULT_OK, intent);
                    finish();
                }
        }
    }
}

