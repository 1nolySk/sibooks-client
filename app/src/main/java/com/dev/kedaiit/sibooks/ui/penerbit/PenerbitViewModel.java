package com.dev.kedaiit.sibooks.ui.penerbit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PenerbitViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PenerbitViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}