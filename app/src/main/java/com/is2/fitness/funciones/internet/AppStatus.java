package com.is2.fitness.funciones.internet;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import java.net.HttpURLConnection;
import java.net.URL;

public class AppStatus {

    private static AppStatus instance = new AppStatus();
    static Context context;
    ConnectivityManager connectivityManager;
    boolean connected = false;
    boolean isInternet = false;

    public static AppStatus getInstance(Context ctx) {
        context = ctx.getApplicationContext();
        return instance;
    }

    public boolean isOnline() {
        try {
            connectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            connected = networkInfo != null && networkInfo.isAvailable() &&
                    networkInfo.isConnected();
            return connected;


        } catch (Exception e) {
            System.out.println("CheckConnectivity Exception: " + e.getMessage());
            Log.v("connectivity", e.toString());
        }
        return connected;
    }
    public boolean hasInternetAccess(){
        try {
            URL url = new URL("http://www.google.com");
            HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
            urlc.setRequestProperty("User-Agent","Test");
            urlc.setRequestProperty("Connection","close");
            urlc.setConnectTimeout(1500);
            urlc.connect();
            isInternet = urlc.getResponseCode() == 200;
            return isInternet;
        }catch (Exception e){
            System.out.println("InternetConnectivity Exception: " + e.getMessage());
            Log.v("connectivity", e.toString());
        }
        return isInternet;
    }

}