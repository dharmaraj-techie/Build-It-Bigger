package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainActivityFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainActivityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_activity, container, false);

        return rootView;
    }


}
