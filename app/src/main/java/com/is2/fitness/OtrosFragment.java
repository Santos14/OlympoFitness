package com.is2.fitness;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.is2.fitness.R;

public class OtrosFragment extends Fragment{
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_otros, container, false);

        // Ubicar argumento en el text view de section_fragment.xml
        //String title = getArguments().getString(ARG_SECTION_TITLE);
        //TextView titulo = (TextView) view.findViewById(R.id.title);
        //titulo.setText(title);
        return view;
    }
}
