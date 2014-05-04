package com.example.app;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FeedFragment extends Fragment {
    public FeedFragment(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_feed, container, false);
        Button mRegisterButton = (Button) rootView.findViewById(R.id.add_button);
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.print("ASS");
                RottenMilk();
            }
        });

        return rootView;
    }

    public void RottenMilk() {
        Fragment fragment = new AddPlayersFragment();

        FragmentTransaction trans = getFragmentManager().beginTransaction();
        trans.replace(R.id.frame_container, fragment);
        trans.addToBackStack(null);
        trans.commit();
    }
}
