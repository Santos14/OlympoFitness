package com.is2.fitness.modulos.productos;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.is2.fitness.funciones.entidad.ItemSimple;
import com.is2.fitness.funciones.adaptador.ItemSimpleAdapter;
import com.is2.fitness.R;

import java.util.Arrays;
import java.util.List;

public class ProductosFragment extends Fragment{

    TextView lblEtiqueta;
    ListView lstOpciones;
    View view = null;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_productos, container, false);

        List<ItemSimple> lista = Arrays.asList(new ItemSimple("Hola1",R.mipmap.ic_launcher,0),
                new ItemSimple("Hola2",R.mipmap.ic_launcher,0),
                new ItemSimple("Hola2",R.mipmap.ic_launcher,0),
                new ItemSimple("Hola2",R.mipmap.ic_launcher,0),
                new ItemSimple("Hola2",R.mipmap.ic_launcher,0),
                new ItemSimple("Hola2",R.mipmap.ic_launcher,0),
                new ItemSimple("Hola2",R.mipmap.ic_launcher,0),
                new ItemSimple("Hola2",R.mipmap.ic_launcher,0));
        lblEtiqueta = (TextView)view.findViewById(R.id.descripcion);
        lstOpciones = (ListView)view.findViewById(R.id.lista);

         //Adaptador
        ItemSimpleAdapter adapter = new ItemSimpleAdapter(view.getContext(),lista);

        lstOpciones.setAdapter(adapter);
        //Eventos
        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                Intent intent = new Intent(v.getContext(),ListaProductos.class);
                Bundle bundle = new Bundle();
                bundle.putString("CATEGORIA", ((ItemSimple) a.getItemAtPosition(position)).getTitulo());
                bundle.putInt("FOTO", ((ItemSimple) a.getItemAtPosition(position)).getImagen());
                intent.putExtras(bundle);
                startActivity(intent);
                //Toast.makeText(v.getContext(),"Posicion: "+position+" | "+"ID: "+id,Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
