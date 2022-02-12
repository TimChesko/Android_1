package com.example.android1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android1.R;

public class ViewAllNotes extends Fragment {

    public static ViewAllNotes newInstance(){
        return new ViewAllNotes();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.all_notes_fragment,container,false);
    }
}
