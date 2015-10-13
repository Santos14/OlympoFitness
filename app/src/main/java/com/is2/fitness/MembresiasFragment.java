package com.is2.fitness;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

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
        List<Item> lista= Arrays.asList(new Item(R.mipmap.ic_launcher, "Titulo1", "Subtitulo1", "", 0),
                new Item(R.mipmap.ic_launcher, "Titulo2", "Subtitulo2", "", 0),
                new Item(R.mipmap.ic_launcher, "Titulo3", "Subtitulo3", "S/. 80.00", 0),
                new Item(R.mipmap.ic_launcher, "Titulo4", "Subtitulo4", "", 0));
        ItemAdapter adapter = new ItemAdapter(lista);
        rv.setAdapter(adapter);

        return view;
    }
}
