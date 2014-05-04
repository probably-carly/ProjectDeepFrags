package com.example.app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by curtis on 2/10/14.
 */
public class LeaderboardFragment extends Fragment {
    public LeaderboardFragment(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_leaderboard, container, false);
        return rootView;
    }

}
