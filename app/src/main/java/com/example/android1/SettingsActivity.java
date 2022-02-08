package com.example.android1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        initView();
        radioGroup();
    }

    private void initView(){
        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);
    }

    private void radioGroup() {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.nightTheme:
                        setTheme(R.style.Theme_Android1_Dark);
                        break;
                    case R.id.lightTheme:
                        setTheme(R.style.Theme_Android1);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                Intent i = new Intent(SettingsActivity.this, MainActivity.class);
                startActivity(i);
        }
    }
}
