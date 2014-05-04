package com.example.app;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.loopj.android.http.*;

import org.json.JSONObject;

/**
 * Created by curtis on 5/4/14.
 */
public class SignInFragment extends Fragment {
    public EditText mUserName;
    public EditText mPassword;
    public String cookie;

    public SignInFragment(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_sign_in, container, false);
        mUserName = (EditText) rootView.findViewById(R.id.username_edittext);
        mPassword = (EditText) rootView.findViewById(R.id.password_edittext);
        Button mRegisterButton = (Button) rootView.findViewById(R.id.login_button);
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String un = mUserName.getText().toString();
                String pw = mPassword.getText().toString();
                makeRequest(un, pw);
            }
        });
        return rootView;
    }

    public void makeRequest(String uName, String pw){
        String dId = getDevIdFromSharedPreferences();
        System.out.print(dId);
        final HttpDeep httpDeep = new HttpDeep();
        System.out.println("******************\nInside makeRequest()\n****************");
        httpDeep.register(dId, uName, pw, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String response) {
                System.out.println(response);
                try {
                    JSONObject json = new JSONObject(response);
                    cookie = json.getString("cookie");
                    httpDeep.setCOOKIE(cookie);

                    Fragment fragment = new FeedFragment();
                    FragmentTransaction trans = getFragmentManager().beginTransaction();
                    trans.replace(R.id.frame_container, fragment);
                    trans.addToBackStack(null);
                    trans.commit();
                    mainUpdateSharedPreferences();
                    } catch (Exception e) {
                    System.out.println("Could not parse JSON \n" + e.toString() );
                }
            }
        });
    }

    public void mainUpdateSharedPreferences() {
        ((MainActivity) getActivity()).UpdateSharedPreferences(cookie);
    }

    public String getDevIdFromSharedPreferences() {

        String myAss = ((MainActivity) getActivity()).getSharedPreference();
        if (myAss == ""){
            return "MYASS";
        }

        return myAss;
    }

}
