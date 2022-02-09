package com.example.android1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    static final String KEY_SP = "sp";
    static final String KEY_CURRENT_THEME = "current_theme";

    static final int NightTheme = 1;
    static final int LightTheme = 2;

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        i = new Intent(SettingsActivity.this, MainActivity.class);
        setTheme(getRealId(getCurrentTheme()));
        setContentView(R.layout.settings_activity);
        initView();
    }

    private void saveTheme(int theme) {
        i.putExtra("KEY_THEME",theme);
        Log.d("myLogs", theme+" - значение theme");
    }

    public void initView() {
        (findViewById(R.id.nightTheme)).setOnClickListener(this);
        (findViewById(R.id.lightTheme)).setOnClickListener(this);
        (findViewById(R.id.back)).setOnClickListener(this);
        switch (getCurrentTheme()) {
            case 1:
                ((RadioButton) findViewById(R.id.nightTheme)).setChecked(true);
                break;
            case 2:
                ((RadioButton) findViewById(R.id.lightTheme)).setChecked(true);
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nightTheme:
                setCurrentTheme(NightTheme);
                saveTheme(NightTheme);
                break;
            case R.id.lightTheme:
                setCurrentTheme(LightTheme);
                saveTheme(LightTheme);
                break;
            case R.id.back:
                startActivity(i);
                break;
        }
        recreate();
    }

    private void setCurrentTheme(int currentTheme) {
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_SP, MODE_PRIVATE);//SharedPreferences - хранение настроек в ОЗУ // MODE_PRIVATE - настроки только для этого приложения
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_CURRENT_THEME, currentTheme);
        editor.apply();
    }

    private int getCurrentTheme() {
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_SP, MODE_PRIVATE);//SharedPreferences - хранение настроек в ОЗУ // MODE_PRIVATE - настроки только для этого приложения
        return sharedPreferences.getInt(KEY_CURRENT_THEME, -1);
    }

    private int getRealId(int currentTheme) {
        switch (currentTheme) {
            case NightTheme:
                return R.style.nightTheme;
            case LightTheme:
                return R.style.lightTheme;
            default:
                return R.style.Theme_Android1;
        }
    }
}
