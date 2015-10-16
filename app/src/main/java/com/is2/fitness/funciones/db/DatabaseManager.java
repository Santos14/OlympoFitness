package com.is2.fitness.funciones.db;

/**
 * Created by USUARIO on 14/10/2015.
 */
public class DatabaseManager {
    //VARIABLES TABLA CATEGORIA DE PRODUCtOS
    public static final String TABLA_CATEGORIA_PRODUCTOS = "cat_productos";
    public static final String CP_ID = "_id";
    public static final String CP_DESCRIPCION = "descripcion";

    //VARIABLES TABLA PRODUCtOS
    public static final String TABLA_PRODUCTOS = "productos";
    public static final String P_ID = "_id";
    public static final String P_CATEGORIA = "categoria";
    public static final String P_MARCA = "marca";
    public static final String P_PRESENTACION = "presentacion";
    public static final String P_NOMBRE = "nombre";
    public static final String P_PRECIO = "precio";

    //VARIABLES TABLA DATOS DE EMPRESA
    public static final String TABLA_EMPRESA = "empresa";
    public static final String E_ID = "_id";
    public static final String E_RAZON_SOCIAL = "razon";
    public static final String E_TELEFONO = "telefono";
    public static final String E_DIRECCION = "direccion";
    public static final String E_FACEBOOK = "facebook";
    public static final String E_TWITTER = "twitter";
    public static final String E_GOOGLEPLUS = "google";
    public static final String E_CELULAR = "celular";
    public static final String E_MAPS = "maps";
    public static final String E_MISION = "mision";
    public static final String E_VISION = "vision";
    public static final String E_HISTORIA = "historia";

    //VARIABLES TABLA DATOS SERVICIOS
    public static final String TABLA_SERVICIO = "servicio";
    public static final String S_ID = "_id";
    public static final String S_NOMBRE= "nombre";
    public static final String S_DESCRIPCION = "descripcion";

    //VARIABLES TABLA DATOS MEMBRESIAS
    public static final String TABLA_MEMBRESIA= "menbresia";
    public static final String M_ID = "_id";
    public static final String M_TIPO= "tipo";
    public static final String M_VIGENCIA = "vigencia";
    public static final String M_COSTO = "costo";
    public static final String M_DESCRIPCION = "descripcion";


    public static final String CREATE_CP = "" +
            "create table "+TABLA_CATEGORIA_PRODUCTOS+" ( " +
                CP_ID + " integer primary key not null," +
                CP_DESCRIPCION + " text);";

    public static final String CREATE_P = "" +
            "create table "+TABLA_PRODUCTOS+" ( " +
            P_ID + " integer primary key not null," +
            P_CATEGORIA+ " text," +
            P_MARCA + " text," +
            P_PRESENTACION+" text," +
            P_NOMBRE+" text," +
            P_PRECIO+" text);";

    public static final String CREATE_E = "" +
            "create table "+TABLA_EMPRESA+" ( " +
            E_ID + " integer primary key not null," +
            E_RAZON_SOCIAL+ " text," +
            E_TELEFONO + " text," +
            E_DIRECCION+" text," +
            E_FACEBOOK+" text," +
            E_TWITTER+" text," +
            E_GOOGLEPLUS+" text," +
            E_CELULAR+" text," +
            E_MAPS+" text," +
            E_MISION+" text," +
            E_VISION+" text," +
            E_HISTORIA+" text);";

    public static final String CREATE_S = "" +
            "create table "+TABLA_SERVICIO+" ( " +
            S_ID + " integer primary key not null," +
            S_NOMBRE+ " text," +
            S_DESCRIPCION+ " text);";

    public static final String CREATE_M = "" +
            "create table "+TABLA_MEMBRESIA+" ( " +
            M_ID + " integer primary key not null," +
            M_TIPO+ " text," +
            M_VIGENCIA + " text," +
            M_COSTO+" text," +
            M_DESCRIPCION+" text);";
}
