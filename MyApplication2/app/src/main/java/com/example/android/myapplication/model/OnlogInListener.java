package com.example.android.myapplication.model;

/**
 * Created by kevinsun on 9/17/17.
 */

public interface OnlogInListener {

    /**
     * this interface will be hooked with another interface and to implement in the presenter to do
     * actions
     * @param user
     */
    void logInSuccess(User user);

    void logInfailed();
}
