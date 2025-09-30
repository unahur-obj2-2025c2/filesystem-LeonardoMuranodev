package ar.edu.unahur.obj2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileSystem {
    private List<IElemento> elementos = new ArrayList<IElemento>();
    private static FileSystem instance = new FileSystem();

    private FileSystem() {}

    public Integer tamanio() {
        return elementos.stream().mapToInt(e -> e.tamanio()).sum();
    }

    public static FileSystem getInstance() {
        return instance;
    }

    public IElemento archivoMasPesado() {
        if (elementos.isEmpty()) {
            throw new RuntimeException("El sistema de archivos está vacio");
        }
        return elementos.stream().map(e -> e.archivoMasPesado()).max(Comparator.comparingInt(e -> e.tamanio())).orElse(new Archivo("archivo vacio", "", 0));
    }

    public Integer nivel(IElemento elemento) {
        return elementos.stream().mapToInt(e -> e.esElElementoOEstaEnEl(elemento, 1)).max().orElse(0);
    }

    public void mostrar(Integer identacion) {
        System.out.println("└ root ( ".concat(this.tamanio().toString()).concat("-Bytes )"));
        elementos.stream().forEach(e -> e.mostrar(identacion));
    }

    public void agregarElemento(IElemento elemento) {
        elementos.add(elemento);
    }

    public void quitarElemento(IElemento elemento) {
        elementos.remove(elemento);
    }
}
