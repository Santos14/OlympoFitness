package com.is2.fitness.funciones.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.is2.fitness.funciones.entidad.ItemSimple;
import com.is2.fitness.R;

import java.util.List;


public class ItemSimpleAdapter extends ArrayAdapter<ItemSimple> {
    List<ItemSimple> lista_simple;

    public ItemSimpleAdapter(Context context, List<ItemSimple> lista_simple) {
        super(context, R.layout.item_simple_layout, lista_simple);
        this.lista_simple = lista_simple;
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View item = convertView;
        ViewHolder holder;

        if(item == null)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            item = inflater.inflate(R.layout.item_simple_layout, null);

            holder = new ViewHolder();
            holder.titulo = (TextView)item.findViewById(R.id.item_simple_titulo);
            holder.imagen = (ImageView) item.findViewById(R.id.imagen);

            item.setTag(holder);
        }
        else
        {
            holder = (ViewHolder)item.getTag();
        }

        holder.titulo.setText(lista_simple.get(position).getTitulo());
        holder.imagen.setImageResource(lista_simple.get(position).getImagen());
        return(item);
    }
    public static class ViewHolder {
        TextView titulo;
        ImageView imagen;
    }


}
