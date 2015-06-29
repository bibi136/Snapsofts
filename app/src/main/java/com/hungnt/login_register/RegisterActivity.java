package com.hungnt.login_register;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class RegisterActivity extends Activity implements View.OnClickListener{

    Button bRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bRegister:
                finish();
        }
    }
}

