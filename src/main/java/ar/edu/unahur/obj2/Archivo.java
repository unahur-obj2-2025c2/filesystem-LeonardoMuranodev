package ar.edu.unahur.obj2;

import java.util.ArrayList;

public class Archivo implements IElemento {
    private String nombre;
    private String extension;
    private Integer pesoEnBytes;

    public Archivo(String nombre, String extension, Integer pesoEnBytes) {
        this.nombre = nombre;
        this.extension = extension;
        this.pesoEnBytes = pesoEnBytes;
    }

    @Override
    public String nombre() {
        return nombre.concat(".").concat(extension);
    }

    @Override
    public Integer tamanio() {
        return pesoEnBytes;
    }

    @Override
    public Integer nivel() {
        return FileSystem.getInstance().nivel(this);
    }

    @Override
    public void mostrar(Integer identacion) {
        String espacios = " ".repeat(identacion);
        String imprimir =  espacios + "├ " + this.nombre();
        System.out.println(imprimir);
    }

    @Override
    public IElemento archivoMasPesado() {
        return this;
    }

    @Override
    public Boolean esElElemento(IElemento elemento) {
        return elemento.nombre().equals(this.nombre()) && elemento.tamanio().equals(this.tamanio());
    }

    @Override
    public Integer esElElementoOEstaEnEl(IElemento elemento, Integer nivel) {
        if (this.esElElemento(elemento)) {
            return nivel;
        } else {
            return 0;
        }
    }
}
