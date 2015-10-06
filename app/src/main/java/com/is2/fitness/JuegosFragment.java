package com.is2.fitness;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.is2.fitness.R;


public class JuegosFragment extends Fragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_juegos, container, false);
        //TextView titulo = (TextView) view.findViewById(R.id.title);
        //titulo.setText(title);
        return view;
    }
}
