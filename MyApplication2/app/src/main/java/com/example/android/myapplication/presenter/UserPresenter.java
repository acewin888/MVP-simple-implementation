package com.example.android.myapplication.presenter;

import android.os.Handler;
import android.util.Log;

import com.example.android.myapplication.model.OnlogInListener;
import com.example.android.myapplication.model.User;
import com.example.android.myapplication.model.UserLogging;
import com.example.android.myapplication.view.LoggingView;

/**
 * Created by kevinsun on 9/17/17.
 */

public class UserPresenter {

    /**
     * the presenter will be the stage where view and model interact wil each other.
     *
     * need to create reference of model and view class, and do according actions.
     */
    //View
    LoggingView loggingView;

    //Model
    UserLogging userLogging;

    /*rease for the handler is that  UserLogging.log is running on the other thread, need to recall
    the action back to main thread for setting the view
      */

    Handler mHandler = new Handler();


    public UserPresenter(LoggingView loggingView) {
        this.loggingView = loggingView;
        userLogging = new UserLogging();
    }

    public void logIn() {
        loggingView.showProgress();

        userLogging.log(loggingView.getUserName(), loggingView.getPassWord(), new OnlogInListener() {
            @Override
            public void logInSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loggingView.toActivity(user);
                        loggingView.hideProgress();
                    }
                });

            }

            @Override
            public void logInfailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loggingView.showError();
                        loggingView.hideProgress();
                    }
                });

            }
        });


    }

    public void clear() {
        loggingView.clearData();

    }
}
