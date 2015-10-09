package com.is2.fitness;

public class Item {
    private int foto;
    private String titulo,subtitulo,subtitulo2;

    public Item(int foto, String titulo, String subtitulo,String subtitulo2) {
        this.foto = foto;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.subtitulo2 = subtitulo2;
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

    public String getSubtitulo2() {
        return subtitulo2;
    }

    public void setSubtitulo2(String subtitulo2) {
        this.subtitulo2 = subtitulo2;
    }
}
