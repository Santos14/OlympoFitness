package com.is2.fitness;

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
        //drawerTitle = getResources().getString(R.string.home_item);
        if (savedInstanceState == null) {
            //selectItem(drawerTitle);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            InicioFragment home = new InicioFragment();
            transaction.add(R.id.main_content,home).commit();
            drawerLayout.closeDrawers();
        }

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
