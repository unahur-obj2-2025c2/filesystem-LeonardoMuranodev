package ar.edu.unahur.obj2;

public interface IElemento {
    String nombre();

    Integer tamanio();

    void mostrar(Integer identacion);

    IElemento archivoMasPesado();

    Boolean esElElemento(IElemento elemento);

    Integer esElElementoOEstaEnEl(IElemento elemento, Integer nivel);

    Integer nivel();
}
