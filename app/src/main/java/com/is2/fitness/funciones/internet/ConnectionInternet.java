package com.is2.fitness.funciones.internet;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by USUARIO on 15/10/2015.
 */
public class ConnectionInternet {
    private String LOG_TAG="ERROR";
    public boolean verificarConexion(Context context){
        boolean bConectado = false;
        ConnectivityManager con = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] redes = con.getAllNetworkInfo();
        for (int i=0;i<2;i++){
            if(redes[i].getState() == NetworkInfo.State.CONNECTED){
                bConectado= true;
            }
        }
        return bConectado;
    }


    public boolean hasInternetAccess(Context context){
        if(verificarConexion(context)){
            try {
                URL url = new URL("http://www.google.com");
                HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
                urlc.setRequestProperty("User-Agent","Test");
                urlc.setRequestProperty("Connection","close");
                urlc.setConnectTimeout(1500);
                urlc.connect();
                return (urlc.getResponseCode() == 200);
            }catch (IOException e){
                Log.e(LOG_TAG,"Erro Chequea la Conexion",e);
            }

        }else{
            Log.d(LOG_TAG,"No network available!");
        }
        return false;
    }
}
