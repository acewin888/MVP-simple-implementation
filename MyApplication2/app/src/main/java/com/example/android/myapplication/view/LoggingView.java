package com.example.android.myapplication.view;

import com.example.android.myapplication.model.User;

/**
 * Created by kevinsun on 9/17/17.
 */

public interface LoggingView {

    String getUserName();

    String getPassWord();

    void clearData();

    void showProgress();

    void hideProgress();

    void toActivity(User user);

    void showError();

}
