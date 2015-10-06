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

import com.is2.fitness.R;

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
            HomeFragment home = new HomeFragment();
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
                        // Marcar item presionado
                        //menuItem.setChecked(true);
                        // Crear nuevo fragmento
                        //String title = menuItem.getTitle().toString();
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
        // Enviar título como arguemento del fragmento
        //Bundle args = new Bundle();
        //args.putString(PlaceholderFragment.ARG_SECTION_TITLE, title);

        //Fragment fragment = PlaceholderFragment.newInstance(title);
        //fragment.setArguments(args);
        boolean enviarFragmento = false;
        Fragment newFragment = null;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (menuItem.getItemId()){
            case R.id.nav_home:
                newFragment = new HomeFragment();
                enviarFragmento = true;
                break;
            case R.id.nav_productos:
                newFragment = new JuegosFragment();
                enviarFragmento = true;
                break;
            case R.id.nav_carrito:
                newFragment = new OtrosFragment();
                enviarFragmento = true;
                break;
            case R.id.nav_ordenes:
                newFragment = new OtrosFragment();
                enviarFragmento = true;
                break;
            case R.id.nav_facturas:
                newFragment = new OtrosFragment();
                enviarFragmento = true;
                break;
            case R.id.nav_log_out:
                newFragment = new OtrosFragment();
                enviarFragmento = true;
                break;

        }

        if(enviarFragmento){
            transaction.replace(R.id.main_content,newFragment).commit();
            menuItem.setChecked(true);
            this.ab.setTitle(menuItem.getTitle());
        }

        /*FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.main_content, fragment)
                .commit();*/

        drawerLayout.closeDrawers(); // Cerrar drawer

        //setTitle(title); // Setear título actual

    }


}
