package com.example.android.myapplication.model;

/**
 * Created by kevinsun on 9/17/17.
 */

public class UserLogging implements OnLogging {
    @Override
    public void log(final String username, final String passWord, final OnlogInListener onlogInListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (username.equals("sun") && passWord.equals("123")) {
                    User user = new User();
                    user.setUserName(username);
                    user.setPassWord(passWord);
                    onlogInListener.logInSuccess(user);
                } else {
                    onlogInListener.logInfailed();
                }
            }
        }).start();
    }
}
