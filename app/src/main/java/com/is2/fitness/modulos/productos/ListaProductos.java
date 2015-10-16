package com.is2.fitness.modulos.productos;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.is2.fitness.R;
import com.is2.fitness.funciones.adaptador.ItemAdapter;
import com.is2.fitness.funciones.entidad.Item;

import java.util.ArrayList;

public class ListaProductos extends AppCompatActivity {
    private ActionBar ab = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);
        Bundle bundle = getIntent().getExtras();
        setToolbar(bundle.getInt("FOTO"),bundle.getString("CATEGORIA"));

        RecyclerView rv = (RecyclerView) findViewById(R.id.lista);
        LinearLayoutManager lim = new LinearLayoutManager(this);
        rv.setLayoutManager(lim);
        ArrayList<Item> lista= new ArrayList<Item>();
        lista.add(new Item(R.mipmap.ic_launcher, "Titulo1", "Subtitulo1", "", 0));
        lista.add(new Item(R.mipmap.ic_launcher, "Titulo1", "Subtitulo1", "", 0));
        lista.add(new Item(R.mipmap.ic_launcher, "Titulo1", "Subtitulo1", "", 0));
        lista.add(new Item(R.mipmap.ic_launcher, "Titulo1", "Subtitulo1", "", 0));
        lista.add(new Item(R.mipmap.ic_launcher, "Titulo1", "Subtitulo1", "", 0));
        ItemAdapter adapter = new ItemAdapter(lista);
        rv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_productos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setToolbar(int foto,String categoria) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            ab.setHomeAsUpIndicator(foto);
            ab.setTitle(categoria);
            ab.setDisplayHomeAsUpEnabled(true);
        }

    }
}
