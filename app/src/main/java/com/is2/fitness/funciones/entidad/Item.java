package com.is2.fitness.funciones.entidad;

public class Item {
    private int foto,identificador;
    private String titulo,subtitulo,subtitulo2;

    public Item(int foto, String titulo, String subtitulo,String subtitulo2,int identificador) {
        this.foto = foto;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.subtitulo2 = subtitulo2;
        this.identificador = identificador;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getSubtitulo2() { return subtitulo2; }

    public void setSubtitulo2(String subtitulo2) {
        this.subtitulo2 = subtitulo2;
    }

    public int getIdentificador() { return identificador; }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
}
