package com.example.stl.sharedpreference;


import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {




    private static final String SHARED_PREFS_KEY = "com.example.stl.sharedpreference";
    private static final String SHARED_PREFS_USERNAME_KEY = "Username";
    private static final String SHARED_PREFS_PASSWORD_KEY = "Password";

    private EditText usernameEditText;
    private EditText passwordEditText;
    private CheckBox saveCredentialsCheckbox;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setOnClickListeners();

        getLoginCredentials();
    }

    private void findViews() {
        usernameEditText = findViewById(R.id.editTextUsername);
        passwordEditText = findViewById(R.id.editTextPassword);
        saveCredentialsCheckbox = findViewById(R.id.saveCredentials);
        submitButton = findViewById(R.id.submit);
    }

    private void setOnClickListeners() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                boolean isSaveCredentialsChecked = saveCredentialsCheckbox.isChecked();

                if (isSaveCredentialsChecked) {
                    saveLoginCredentials(username, password);
                }
            }
        });
    }

    private void getLoginCredentials() {
        String username = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE)
                .getString(SHARED_PREFS_USERNAME_KEY, "");
        String password = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE)
                .getString(SHARED_PREFS_PASSWORD_KEY, "");

        usernameEditText.setText(username);
        passwordEditText.setText(password);
    }

    private void saveLoginCredentials(@NonNull String username, @NonNull String password) {
        getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE)
                .edit()
                .putString(SHARED_PREFS_USERNAME_KEY, username)
                .putString(SHARED_PREFS_PASSWORD_KEY, password)
                .apply();
        Toast.makeText(this, "Login credentials saved! " + username, Toast.LENGTH_SHORT).show();
    }
}




//Question 1:
//Following the app displayed in today's lesson, recreate your own sign-in
// page with persistence, the opportunity to register, and a page to go to
// when signed in, which is unique to the user. When completed, push to a
// GitHub repository, and paste the link here.
//
//Question 2:
//Using SharedPreferences and Intents, create an app that allows a user
// to enter their favorite foods into storage in one activity,
// then move to another activity, so that a friend can guess if a food is
// on the list. Display a toast on the screen whenever the food is
// correctly on the list, or is missing from the list.
//
//When completed, push to a GitHub repository, and paste the link here.