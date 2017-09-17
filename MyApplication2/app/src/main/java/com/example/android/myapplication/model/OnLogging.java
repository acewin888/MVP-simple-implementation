package com.example.android.myapplication.model;

/**
 * Created by kevinsun on 9/17/17.
 */


/**
 * this interface will be implemented by UserLogging to simulate logging process
 */
public interface OnLogging {

    void log(String username, String passWord, OnlogInListener onlogInListener);
}
