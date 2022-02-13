package com.example.android1;

import android.os.Parcel;
import android.os.Parcelable;

public class DataClass implements Parcelable {
    private String titleNote;
    private int indexNote;

    public DataClass(String titleNote, int indexNote, String viewNote, String dataCreateNote) {
        this.titleNote = titleNote;
        this.indexNote = indexNote;
        this.viewNote = viewNote;
        this.dataCreateNote = dataCreateNote;
    }

    private String viewNote;
    private String dataCreateNote;

    protected DataClass(Parcel in) {
        titleNote = in.readString();
        viewNote = in.readString();
        dataCreateNote = in.readString();
    }

    public static final Creator<DataClass> CREATOR = new Creator<DataClass>() {
        @Override
        public DataClass createFromParcel(Parcel in) {
            return new DataClass(in);
        }

        @Override
        public DataClass[] newArray(int size) {
            return new DataClass[size];
        }
    };

    public String getTitleNote() {
        return titleNote;
    }

    public void setTitleNote(String titleNote) {
        this.titleNote = titleNote;
    }

    public int getIndexNote() {
        return indexNote;
    }

    public void setIndexNote(int indexNote) {
        this.indexNote = indexNote;
    }

    public String getViewNote() {
        return viewNote;
    }

    public void setViewNote(String viewNote) {
        this.viewNote = viewNote;
    }

    public String getDataCreateNote() {
        return dataCreateNote;
    }

    public void setDataCreateNote(String dataCreateNote) {
        this.dataCreateNote = dataCreateNote;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(titleNote);
        parcel.writeInt(indexNote);
        parcel.writeString(viewNote);
        parcel.writeString(dataCreateNote);
    }
}
