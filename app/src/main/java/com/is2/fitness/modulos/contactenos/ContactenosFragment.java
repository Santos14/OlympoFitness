package com.is2.fitness.modulos.contactenos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.is2.fitness.R;

public class ContactenosFragment extends Fragment {
    private ImageView imagen;
    private TextView tit_vision,des_vision,tit_mision,des_mision;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contactenos, container, false);

        imagen = (ImageView) view.findViewById(R.id.imagen_conocenos);
        tit_mision = (TextView) view.findViewById(R.id.mision_titulo);
        des_mision = (TextView) view.findViewById(R.id.mision_descripcion);
        tit_vision= (TextView) view.findViewById(R.id.vision_titulo);
        des_vision = (TextView) view.findViewById(R.id.vision_descripcion);

        imagen.setBackgroundResource(R.drawable.background_material);
        tit_mision.setText("MISION");
        des_mision.setText("afsdfsdfsdfsdafsadfsdfsdafffffffffffffffffffffffffffffsadfsdfsdafsdfsdsdafads");
        tit_vision.setText("VISION");
        des_vision.setText("afsdfsdfsdfsdafsadfsdfsdafffffffffffffffffffffffffffffsadfsdfsdafsdfsdsdafads");
        return view;
    }
}
