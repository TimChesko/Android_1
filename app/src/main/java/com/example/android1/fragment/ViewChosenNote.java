package com.example.android1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.android1.DataClass;
import com.example.android1.R;

public class ViewChosenNote extends Fragment {

    public static String ARG_INTO_NOTE = "ARG_INTO_NOTE";
    private DataClass dataClass;

    public static ViewChosenNote newInstance(DataClass dataClass) {
        ViewChosenNote fragment = new ViewChosenNote();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_INTO_NOTE, dataClass);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.dataClass = getArguments().getParcelable(ARG_INTO_NOTE);
        }
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chosen_note_fragment, container, false);

        TextView textView = view.findViewById(R.id.titleView);
        TextView descriptionView = view.findViewById(R.id.descriptionView);

        textView.setText(this.dataClass.getTitleNote());
        descriptionView.setText(this.dataClass.getViewNote());

        return view;
    }
}
