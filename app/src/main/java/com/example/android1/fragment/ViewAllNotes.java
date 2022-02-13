package com.example.android1.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.android1.DataClass;
import com.example.android1.R;

public class ViewAllNotes extends Fragment {

    DataClass currentData;
    public static String KEY_TITLE_NOTE = "KEY_TITLE_NOTE";
    boolean isLandScape;

    public static ViewAllNotes newInstance() {
        return new ViewAllNotes();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isLandScape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

        if (savedInstanceState != null) {
            currentData = savedInstanceState.getParcelable(KEY_TITLE_NOTE);
        }

        if (isLandScape)
            if (currentData != null) {
                showCoatOfArms(currentData.getIndexNote());
            } else {
                showCoatOfArms(0);
            }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(KEY_TITLE_NOTE, currentData);
        super.onSaveInstanceState(outState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_notes_fragment, container, false);
        LinearLayout linearLayout = (LinearLayout) view;

        String[] notes = getResources().getStringArray(R.array.title_note);

        for (int i = 0; i < notes.length; i++) {
            String name = notes[i];
            TextView textView = new TextView(getContext());
            textView.setText(name);
            textView.setTextSize(30);
            linearLayout.addView(textView);
            int finalI = i;
            textView.setOnClickListener(v -> showCoatOfArms(finalI));
        }
        return view;
    }

    private void showCoatOfArms(int index) {
        currentData = new DataClass(getResources().getStringArray(R.array.title_note)[index], index, getResources().getStringArray(R.array.into_note)[index], getResources().getStringArray(R.array.data_note)[index]);
        if (isLandScape) {
            showIntoNotesLand();
        } else { // port
            showIntoNotesPort();
        }
    }

    private void showIntoNotesPort() {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_left, ViewChosenNote.newInstance(currentData))
                .addToBackStack("")
                .commit();
    }

    private void showIntoNotesLand() {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_right, ViewChosenNote.newInstance(currentData))
                .commit();
    }

}
