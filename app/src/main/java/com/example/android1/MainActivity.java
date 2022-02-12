package com.example.android1;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android1.fragment.ViewAllNotes;
import com.example.android1.fragment.ViewChosenNote;

//CTRL + ALT + O - удаление лишних import
//CTRL + ALT + L - форматировать
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_left, ViewAllNotes.newInstance())
                .commit();
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_right, ViewChosenNote.newInstance())
                    .commit();
        }
    }
}