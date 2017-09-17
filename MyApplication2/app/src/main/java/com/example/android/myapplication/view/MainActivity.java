package com.example.android.myapplication.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.android.myapplication.R;
import com.example.android.myapplication.model.User;
import com.example.android.myapplication.presenter.UserPresenter;

public class MainActivity extends AppCompatActivity implements LoggingView {

    EditText userNameView, passWordView;

    Button logButton, clearButton;

    ProgressBar mProgressBar;

    UserPresenter presenter = new UserPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameView = (EditText) findViewById(R.id.user_name_editText);
        passWordView = (EditText) findViewById(R.id.passWord_editText);
        logButton = (Button) findViewById(R.id.button_log_in);
        clearButton = (Button) findViewById(R.id.button_clear);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);


        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.logIn();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.clear();
            }
        });
    }

    @Override
    public String getUserName() {
        return userNameView.getText().toString();
    }

    @Override
    public String getPassWord() {
        return passWordView.getText().toString();
    }

    @Override
    public void clearData() {
        userNameView.setText("");
        passWordView.setText("");
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void toActivity(User user) {
        Toast.makeText(MainActivity.this, "successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError() {
        Toast.makeText(MainActivity.this, "Error, not Logged in", Toast.LENGTH_SHORT).show();

    }
}
