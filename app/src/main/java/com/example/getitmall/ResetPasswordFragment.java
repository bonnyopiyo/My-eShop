package com.example.getitmall;


import android.graphics.Color;
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
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResetPasswordFragment extends Fragment {


    public ResetPasswordFragment() {
        // Required empty public constructor
    }

    private EditText registeredEmail;
    private Button resetPasswordBtn;
    private TextView goBack;

    private FrameLayout parentFrameLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reset_password, container, false);

        registeredEmail = view.findViewById(R.id.forgot_password_email);
        resetPasswordBtn = view.findViewById(R.id.reset_password_btn);
        goBack = view.findViewById(R.id.tv_forgot_password_go_back);

        parentFrameLayout = getActivity().findViewById(R.id.register_framelayout);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        registeredEmail.addTextChangedListener(new TextWatcher() {
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

        resetPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPasswordBtn.setEnabled(false);
                resetPasswordBtn.setTextColor(Color.argb(50, 255, 255, 255));

            }
        });
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignInFragment());
            }

        });
    }

    private void checkInputs() {
        if (TextUtils.isEmpty(registeredEmail.getText())) {
            resetPasswordBtn.setEnabled(false);
            resetPasswordBtn.setTextColor(Color.argb(50, 255, 255, 255));
        } else {
            resetPasswordBtn.setEnabled(true);
            resetPasswordBtn.setTextColor(Color.rgb(255, 255, 255));

        }
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slideout_from_right);
        fragmentTransaction.replace(parentFrameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }
}