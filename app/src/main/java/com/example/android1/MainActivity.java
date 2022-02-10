package com.example.android1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

//CTRL + ALT + O - удаление лишних import
//CTRL + ALT + L - форматировать
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}