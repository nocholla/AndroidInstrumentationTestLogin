package com.nocholla.instrumentationtestlogin;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    // ButterKnife
    @BindView(R.id.username)
    EditText inputUsername;
    @BindView(R.id.password)
    EditText inputPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.view_background_color)
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ButterKnife
        ButterKnife.bind(this);

        // Login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = inputUsername.getText().toString();
                Log.d("DEBUG USERNAME", username);

                final String password = inputPassword.getText().toString();
                Log.d("DEBUG PASSWORD", password);

                // Username = edureka & Password = edureka123" Validation
                if(username.matches("edureka") && password.matches("edureka123\"")) {
                    // Toast On Success
                    Toast.makeText(MainActivity.this, getString(R.string.toast_success), Toast.LENGTH_SHORT).show();
                    
                    // Background Color on Success
                    constraintLayout.setBackgroundColor(Color.GREEN);
                } else {
                    // Background Color on Fail
                    constraintLayout.setBackgroundColor(Color.RED);
                }

                // Wrong Username
                if(!username.matches("edureka")) {
                    inputUsername.setError(getString(R.string.error_wrong_username));
                }

                // Wrong Password
                if(!password.matches("edureka123\"")) {
                    inputPassword.setError(getString(R.string.error_wrong_password));
                }

                // Username Empty Validation
                if (TextUtils.isEmpty(username)) {
                    inputUsername.setError(getString(R.string.error_enter_username));

                    return;
                }

                // Password Empty Validation
                if (TextUtils.isEmpty(password)) {
                    inputPassword.setError(getString(R.string.error_enter_password));

                    return;
                }
            }
        });

    }
}
