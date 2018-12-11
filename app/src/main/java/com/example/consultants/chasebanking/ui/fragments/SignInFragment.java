package com.example.consultants.chasebanking.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.consultants.chasebanking.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SignInFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SignInFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignInFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_EMAIL = "email";
    private static final String ARG_PASS = "pass";

    private String mEmail;
    private String mPass;

    private OnFragmentInteractionListener mListener;

    public SignInFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param email Parameter for email.
     * @param password Parameter for password.
     * @return A new instance of fragment SignInFragment.
     */

    public static SignInFragment newInstance(String email, String password) {
        SignInFragment fragment = new SignInFragment();
        Bundle args = new Bundle();
        args.putString(ARG_EMAIL, email);
        args.putString(ARG_PASS, password);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mEmail = getArguments().getString(ARG_EMAIL);
            mPass = getArguments().getString(ARG_PASS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }

    public void onSignInPressed(String email, String password) {
        if (mListener != null) {
            mListener.fromFragmentSignIn(email, password);
        }
    }

    //attaching fragment
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    //detaching fragment
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    //handles clicks within the fragment
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnSignIn:
                EditText etEmail = v.findViewById(R.id.etEmail);
                EditText etPassword = v.findViewById(R.id.etPassword);

                onSignInPressed(etEmail.getText().toString(), etPassword.getText().toString());

                break;
        }
    }

    //interface to be implemented by activities containing fragment
    public interface OnFragmentInteractionListener {

        void fromFragmentSignIn(String email, String password);
    }
}
