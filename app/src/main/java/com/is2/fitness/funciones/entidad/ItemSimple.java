package com.is2.fitness.funciones.entidad;

/**
 * Created by USUARIO on 09/10/2015.
 */
public class ItemSimple {
    private String titulo;
    private int imagen,identificador;

    public ItemSimple(String titulo, int imagen,int identificador) {
        this.titulo = titulo;
        this.imagen = imagen;
        this.identificador = identificador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getIdentificador() { return identificador; }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

}
