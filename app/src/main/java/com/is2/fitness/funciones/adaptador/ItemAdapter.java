package com.is2.fitness.funciones.adaptador;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.is2.fitness.funciones.entidad.Item;
import com.is2.fitness.R;

import java.util.ArrayList;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    ArrayList<Item> listaitem;

    public ItemAdapter(ArrayList<Item> listaitem) {
        this.listaitem = listaitem;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        ItemViewHolder holder = new ItemViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.foto.setImageResource(listaitem.get(position).getFoto());
        holder.titulo.setText(listaitem.get(position).getTitulo());
        holder.subtitulo.setText(listaitem.get(position).getSubtitulo());
        holder.subtitulo2.setText(listaitem.get(position).getSubtitulo2());
    }

    @Override
    public int getItemCount() {
        return listaitem.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView foto;
        TextView titulo,subtitulo,subtitulo2;
        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            foto = (ImageView) itemView.findViewById(R.id.foto);
            titulo = (TextView) itemView.findViewById(R.id.txt_titulo);
            subtitulo = (TextView) itemView.findViewById(R.id.txt_subtitulo);
            subtitulo2 = (TextView) itemView.findViewById(R.id.txt_subtitulo2);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(),"Hiso CLICK",Toast.LENGTH_SHORT).show();
        }
    }
}
