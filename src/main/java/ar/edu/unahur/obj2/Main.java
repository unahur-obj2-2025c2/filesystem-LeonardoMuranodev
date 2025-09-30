package ar.edu.unahur.obj2;

public class Main {
    public static void main(String[] args) {
        FileSystem sistemaArchivo = FileSystem.getInstance();
        sistemaArchivo.agregarElemento(new Archivo("Notas", "txt", 10));
        sistemaArchivo.agregarElemento(new Archivo("Dibujo-A", "jpg", 290));

        Carpeta carpetaA = new Carpeta("Carpeta A");
        sistemaArchivo.agregarElemento(carpetaA);
        carpetaA.agregarElemento(new Archivo("Imagen-A", "jpg", 140));
        carpetaA.agregarElemento(new Archivo("Rock", "mp3", 500));

        Carpeta carpetaB = new Carpeta("Carpeta b");
        carpetaA.agregarElemento(carpetaB);
        carpetaB.agregarElemento(new Archivo("Imagen-A", "jpg", 140));
        carpetaB.agregarElemento(new Archivo("Rock", "mp3", 500));
        sistemaArchivo.mostrar(3);
    }
}
