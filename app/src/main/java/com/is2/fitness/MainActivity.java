package com.is2.fitness;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.is2.fitness.funciones.internet.AppStatus;
import com.is2.fitness.modulos.conocenos.ConocenosFragment;
import com.is2.fitness.modulos.contactenos.ContactenosFragment;
import com.is2.fitness.modulos.inicio.InicioFragment;
import com.is2.fitness.modulos.menbresias.MembresiasFragment;
import com.is2.fitness.modulos.productos.ProductosFragment;
import com.is2.fitness.modulos.servicios.ServiciosFragment;

public class MainActivity extends AppCompatActivity {
    /**
     * Instancia del drawer
     */
    private DrawerLayout drawerLayout;

    /**
     * Titulo inicial del drawer
     */
    private String drawerTitle;
    private ActionBar ab = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);
            setToolbar(); // Setear Toolbar como action bar

            drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            if (navigationView != null) {
                setupDrawerContent(navigationView);
            }

            if (savedInstanceState == null) {

                //selectItem(drawerTitle);
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                InicioFragment home = new InicioFragment();
                transaction.add(R.id.main_content, home).commit();
                drawerLayout.closeDrawers();
            }

        new conexion(this).execute();

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }

    }
    private class conexion extends AsyncTask<Void,Void,Boolean> {
        Context context;
        AlertDialog.Builder alerta = null;
        public conexion(Context context) {
            this.context = context;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            if (AppStatus.getInstance(this.context).isOnline()) {
                if (AppStatus.getInstance(this.context).hasInternetAccess()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        protected void onPostExecute(Boolean estado){
            if(!estado){
                alerta = new AlertDialog.Builder(this.context);
                alerta.setTitle("Olympo Fitness");
                alerta.setMessage("Al parecer no cuentas con Internet, verifica tu conexion e intenta nuevamente");
                alerta.setCancelable(false);
                alerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                alerta.create();
                alerta.setIcon(R.mipmap.ic_launcher);
                alerta.show();
            }
        }
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectItem(menuItem);
                        return true;
                    }
                }
        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void selectItem(MenuItem menuItem) {//String title

        boolean enviarFragmento = false;
        Fragment newFragment = null;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        String titulo = "";
        switch (menuItem.getItemId()){
            case R.id.nav_home:
                newFragment = new InicioFragment();
                //titulo = "Olympo Fitness";
                enviarFragmento = true;
                break;
            case R.id.nav_conocenos:
                newFragment = new ConocenosFragment();
                enviarFragmento = true;
                //titulo =(String) menuItem.getTitle();
                break;
            case R.id.nav_productos:
                newFragment = new ProductosFragment();
                //titulo =(String) menuItem.getTitle();
                enviarFragmento = true;

                break;
            case R.id.nav_servicios:
                newFragment = new ServiciosFragment();
                //titulo =(String) menuItem.getTitle();
                enviarFragmento = true;
                break;
            case R.id.nav_menbresias:
                newFragment = new MembresiasFragment();
                //titulo =(String) menuItem.getTitle();
                enviarFragmento = true;
                break;
            case R.id.nav_contactenos:
                newFragment = new ContactenosFragment();
                //titulo =(String) menuItem.getTitle();
                enviarFragmento = true;
                break;
            case R.id.nav_log_out:
                Toast.makeText(getApplicationContext(),"Pronto Implementaremos esta Opcion",Toast.LENGTH_SHORT).show();
                enviarFragmento = false;
                break;

        }

        if(enviarFragmento){
            transaction.replace(R.id.main_content,newFragment).commit();
            menuItem.setChecked(true);
            this.ab.setTitle(menuItem.getTitle());
        }



        drawerLayout.closeDrawers(); // Cerrar drawer



    }


}
