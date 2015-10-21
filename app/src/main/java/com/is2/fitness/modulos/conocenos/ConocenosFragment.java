package com.is2.fitness.modulos.conocenos;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.is2.fitness.R;
import com.is2.fitness.funciones.internet.AppStatus;

import java.util.ArrayList;
import java.util.Objects;


public class ConocenosFragment extends Fragment{
    private ImageView imagen;
    private TextView tit_vision,des_vision,tit_mision,des_mision;



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conocenos, container, false);


        imagen = (ImageView) view.findViewById(R.id.imagen_conocenos);
        tit_mision = (TextView) view.findViewById(R.id.mision_titulo);
        des_mision = (TextView) view.findViewById(R.id.mision_descripcion);
        tit_vision= (TextView) view.findViewById(R.id.vision_titulo);
        des_vision = (TextView) view.findViewById(R.id.vision_descripcion);





        return view;
    }
    public void CargarConocenos(int imagen,String mision,String vision){
        this.imagen.setBackgroundResource(imagen);
        this.tit_mision.setText("MISIÓN");
        this.des_mision.setText(mision);
        this.tit_vision.setText("VISIÓN");
        this.des_vision.setText(vision);
    }

}
