package com.example.consultants.chasebanking.ui.signin;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.consultants.chasebanking.util.CompleteListener;
import com.example.consultants.chasebanking.R;
import com.example.consultants.chasebanking.ui.fragments.SignInFragment;
import com.example.consultants.chasebanking.util.UserAuthenticator;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity implements SignInFragment.OnFragmentInteractionListener,
        UserAuthenticator.Callback {
    public static final String TAG = SignInActivity.class.getSimpleName() + "_TAG";

    private UserAuthenticator userAuthenticator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        userAuthenticator = new UserAuthenticator(this, new CompleteListener(this));

        FragmentManager fm = getSupportFragmentManager();
        SignInFragment signInFragment = SignInFragment.newInstance("todo", "fromSharedPrefs");
        fm.beginTransaction().add(R.id.fragSignInHolder, signInFragment, "signInFragment").commit();
    }

    @Override
    public void fromFragmentSignIn(String email, String password) {
        userAuthenticator.signIn(email, password);
    }


    private void startPeopleActivity() {
//        Intent intent = new Intent(getApplicationContext(), PeopleActivity.class);
//        startActivity(intent);
    }

    @Override
    public void onUserValidated(FirebaseUser user) {
        Toast.makeText(this, "Welcome " + user.getEmail(), Toast.LENGTH_SHORT).show();
        startPeopleActivity();
    }

    @Override
    public void onUserInvalidated() {
        Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show();
    }

}
