package com.example.getitmall;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {


    public SignUpFragment() {
        // Required empty public constructor
    }

    private TextView alreadyHaveAnAccount;
    private FrameLayout parentFrameLayout;

    private EditText email;
    private EditText fullnames;
    private EditText password;
    private EditText cofirmPassword;

    private Button SignUpBtn;

    private ProgressBar progressBar;

    private String emailpattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        alreadyHaveAnAccount = view.findViewById(R.id.tv_already_have_an_account);
        parentFrameLayout = getActivity().findViewById(R.id.register_framelayout);
        email = view.findViewById(R.id.sign_up_email);
        fullnames = view.findViewById(R.id.sign_up_fullnames);
        password= view.findViewById(R.id.sign_up_password);
        cofirmPassword = view.findViewById(R.id.sign_up_confirm_password);

        SignUpBtn = view.findViewById(R.id.sign_up_btn);

        progressBar = view.findViewById(R.id.sign_up_progressbar);



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        alreadyHaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignInFragment());
            }
        });
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        fullnames.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        cofirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        SignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEmailAndPassword();
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left,R.anim.slideout_from_right);
        fragmentTransaction.replace(parentFrameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }
    private void checkInputs(){
        if (!TextUtils.isEmpty(email.getText())){
            if (!TextUtils.isEmpty(fullnames.getText())){
                if (!TextUtils.isEmpty(password.getText())){
                    if (!TextUtils.isEmpty(cofirmPassword.getText())){
                        SignUpBtn.setEnabled(true);
                        SignUpBtn.setTextColor(Color.rgb(255,255,255));

                    }else {
                        SignUpBtn.setEnabled(false);
                        SignUpBtn.setTextColor(Color.argb(50,255,255,255));

                    }

                }else {
                    SignUpBtn.setEnabled(false);
                    SignUpBtn.setTextColor(Color.argb(50,255,255,255));

                }

            }else {
                SignUpBtn.setEnabled(false);
                SignUpBtn.setTextColor(Color.argb(50,255,255,255));

            }

        }else{
            SignUpBtn.setEnabled(false);
            SignUpBtn.setTextColor(Color.argb(50,255,255,255));

        }
    }
    private void checkEmailAndPassword(){

        if (email.getText().toString().matches(emailpattern)){

            if (password.getText().toString().equals(cofirmPassword.getText().toString())){

                progressBar.setVisibility(View.VISIBLE);
                SignUpBtn.setEnabled(false);
                SignUpBtn.setTextColor(Color.argb(50,255,255,255));

                Intent mainIntent = new Intent(getActivity(),MainActivity.class);
                startActivity(mainIntent);
                getActivity().finish();


            }else {
                cofirmPassword.setError("password doesn't Matched!");

            }
        }else {
            email.setError("Invalid email Address");
        }


        }
    }
