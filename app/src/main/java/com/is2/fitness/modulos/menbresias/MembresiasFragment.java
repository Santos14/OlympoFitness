package com.is2.fitness.modulos.menbresias;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.is2.fitness.funciones.entidad.Item;
import com.is2.fitness.funciones.adaptador.ItemAdapter;
import com.is2.fitness.R;

import java.util.ArrayList;

/**
 * Created by USUARIO on 06/10/2015.
 */
public class MembresiasFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menbresias, container, false);

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.lista);
        LinearLayoutManager lim = new LinearLayoutManager(view.getContext());
        rv.setLayoutManager(lim);
        ArrayList<Item> lista= new ArrayList<Item>();
        lista.add(new Item(R.mipmap.ic_launcher, "Titulo1", "Subtitulo1", "", 0));
        lista.add(new Item(R.mipmap.ic_launcher, "Titulo1", "Subtitulo1", "", 0));
        lista.add(new Item(R.mipmap.ic_launcher, "Titulo1", "Subtitulo1", "", 0));
        lista.add(new Item(R.mipmap.ic_launcher, "Titulo1", "Subtitulo1", "", 0));
        lista.add(new Item(R.mipmap.ic_launcher, "Titulo1", "Subtitulo1", "", 0));
        ItemAdapter adapter = new ItemAdapter(lista);
        rv.setAdapter(adapter);

        return view;
    }
}
