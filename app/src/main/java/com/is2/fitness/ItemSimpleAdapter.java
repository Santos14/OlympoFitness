package com.is2.fitness;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class ItemSimpleAdapter extends ArrayAdapter<ItemSimple> {
    List<ItemSimple> lista_simple;

    public ItemSimpleAdapter(Context context, List<ItemSimple> lista_simple) {
        super(context,R.layout.item_simple_layout, lista_simple);
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
            holder.subtitulo = (TextView)item.findViewById(R.id.item_simple_subtitulo);
            holder.imagen = (ImageView) item.findViewById(R.id.imagen);

            item.setTag(holder);
        }
        else
        {
            holder = (ViewHolder)item.getTag();
        }

        holder.titulo.setText(lista_simple.get(position).getTitulo());
        holder.subtitulo.setText(lista_simple.get(position).getSubtitulo());
        holder.imagen.setImageResource(lista_simple.get(position).getImagen());
        return(item);
    }
    public static class ViewHolder {
        TextView titulo;
        TextView subtitulo;
        ImageView imagen;
    }


}
