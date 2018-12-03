package com.example.consultants.chasebanking;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity implements SignInFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        FragmentManager fm = getSupportFragmentManager();
        SignInFragment signInFragment = SignInFragment.newInstance("todo", "fromSharedPrefs");
        fm.beginTransaction().add(R.id.fragSignInHolder, signInFragment, "signInFragment").commit();
    }

    @Override
    public void onSignIn(String login) {

    }

    @Override
    public void showToast(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }
}
