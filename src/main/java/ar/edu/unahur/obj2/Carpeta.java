package ar.edu.unahur.obj2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carpeta implements IElemento{
    private String nombre;
    private List<IElemento> elementos = new ArrayList<IElemento>();

    //Constructores

    public Carpeta(String nombre) {
        this.nombre = nombre;
    }

    public Carpeta(String nombre, List<IElemento> elementos) {
        this.nombre = nombre;
        this.elementos = elementos;
    }

    @Override
    public String nombre() {
        return nombre;
    }

    @Override
    public Integer tamanio() {
        return elementos.stream().mapToInt(e -> e.tamanio()).sum();
    }

    @Override
    public Boolean esElElemento(IElemento elemento) {
        return this.nombre().equals(elemento.nombre());
    }

    @Override
    public Integer esElElementoOEstaEnEl(IElemento elemento, Integer nivel) {
        if (this.esElElemento(elemento)) {
            return nivel;
        } else if (this.elementos.isEmpty()) {
            return 0;
        } else {
            return elementos.stream().mapToInt(e -> e.esElElementoOEstaEnEl(elemento, nivel + 1)).sum();
        }
    }

    @Override
    public void mostrar(Integer identacion) {
        Integer nivel =  this.nivel();
        String espacios = " ".repeat(identacion);
        String nivelStr = "Nivel " + nivel + " ";
        String imprimir =  espacios + "└ " + this.nombre()+ " " + nivelStr + " ( " + this.tamanio().toString() + "-Bytes )";
        System.out.println(imprimir);
        elementos.stream().forEach(e -> e.mostrar(identacion + identacion / nivel));
    }

    @Override
    public IElemento archivoMasPesado() {
        if (elementos.isEmpty()) {
            throw new RuntimeException("La carpeta está vacia");
        }
        return elementos.stream().max(Comparator.comparingInt(e -> e.tamanio())).orElse(new Archivo("archivo vacio", "", 0));
    }

    public void agregarElemento(IElemento elemento) {
        elementos.add(elemento);
    }

    public void quitarElemento(IElemento elemento) {
        elementos.remove(elemento);
    }

    @Override
    public Integer nivel() {
        return FileSystem.getInstance().nivel(this);
    }
}
