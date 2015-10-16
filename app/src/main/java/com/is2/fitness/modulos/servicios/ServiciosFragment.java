package com.is2.fitness.modulos.servicios;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import com.is2.fitness.funciones.entidad.Item;
import com.is2.fitness.funciones.adaptador.ItemAdapter;
import com.is2.fitness.R;
import com.loopj.android.http.*;

import org.json.JSONArray;

import cz.msebera.android.httpclient.Header;

public class ServiciosFragment extends Fragment {
    RecyclerView rv=null;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_servicios, container, false);
        //enviarDatos("PUTITO","23456789");
        rv = (RecyclerView) view.findViewById(R.id.lista);
        LinearLayoutManager lim = new LinearLayoutManager(view.getContext());
        rv.setLayoutManager(lim);

        /*List<Item> lista= Arrays.asList(new Item(R.mipmap.ic_launcher, "Titulo1", "Subtitulo1", "", 0),
                new Item(R.mipmap.ic_launcher, "Titulo2", "Subtitulo2", "", 0),
                new Item(R.mipmap.ic_launcher, "Titulo3", "Subtitulo3", "S/. 80.00", 0),
                new Item(R.mipmap.ic_launcher, "Titulo4", "Subtitulo4", "", 0));*/
        ObtDatos();
       // ItemAdapter adapter = new ItemAdapter(lista);
       // rv.setAdapter(adapter);


        return view;
    }
    public void enviarDatos(String nombre,String dni){
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://192.168.1.44/json/putdata.php?";
        String parametros = "nombre="+nombre+"&dni="+dni;
        client.post(url + parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
                    String resultado = new String(responseBody);
                    //Toast.makeText(null,"Todo Ok:"+resultado,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void ObtDatos(){
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://192.168.1.44/json/index.php";

        RequestParams parametros = new RequestParams();
        parametros.put("Edad",18);

        client.post(url, parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode==200){
                    CargarLista(obtDatosJSON(new String(responseBody)));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
    public void CargarLista(ArrayList<Item> lista){
        ItemAdapter adapter = new ItemAdapter(lista);
        rv.setAdapter(adapter);
    }

    public ArrayList<Item> obtDatosJSON(String response){
        ArrayList<Item> listado = new ArrayList<Item>();
        try {
            JSONArray jsonArray = new JSONArray(response);
            String texto;
            for (int i=0; i< jsonArray.length();i++){
                Item dato = new Item(R.mipmap.ic_launcher,jsonArray.getJSONObject(i).getString("nombre"),
                        jsonArray.getJSONObject(i).getString("dni"),"",0);

                listado.add(dato);

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listado;

    }
}
