package com.example.android1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.android1.fragment.ViewAllNotes;
import com.example.android1.fragment.ViewChosenNote;

//CTRL + ALT + O - удаление лишних import
//CTRL + ALT + L - форматировать
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_left, ViewAllNotes.newInstance())
                    .commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // ищем фрагмент, который сидит в контейнере R.id.cities_container
        Fragment backStackFragment = getSupportFragmentManager()
                .findFragmentById(R.id.fragment_container_left);
        // если такой есть, и он является CoatOfArmsFragment
        if (backStackFragment instanceof ViewChosenNote) {
            //то сэмулируем нажатие кнопки Назад
            onBackPressed();
        }
    }
}