package com.is2.fitness.modulos.inicio;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.is2.fitness.R;


public class InicioFragment extends Fragment{
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        // Ubicar argumento en el text view de section_fragment.xml
        //String title = getArguments().getString(ARG_SECTION_TITLE);
        //TextView titulo = (TextView) view.findViewById(R.id.title);
        //titulo.setText(title);
        return view;
    }
}
